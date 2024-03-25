import model.Artist;
import model.Datasource;
import model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_NONE);
        if(artists == null){
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists){
            System.out.println("ID = " + artist.getId() + ", Name = " +artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);

        for (String album: albumsForArtist){
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_ASC);
        if(songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for (SongArtist artist : songArtists){
            System.out.println("Artist name = " + artist.getArtistName() + " Album name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }

        datasource.querySongsMetaData();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtist();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = scanner.nextLine();
//
//        songArtists = datasource.querySongInfoView("Go Your Own Way");
//        if(songArtists.isEmpty()){
//            System.out.println("Couldn't find artist for the song");
//            return;
//        }
//
//        for (SongArtist artist : songArtists ){
//            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
//                    " Album name = " + artist.getAlbumName() +
//                    " Track number = " + artist.getTrack());
//        }

        datasource.insertSong("Touch of Grey", "Grateful Day", "In The Dark", 1);
        datasource.close();
    }
}