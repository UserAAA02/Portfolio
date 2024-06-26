package com.example.musicui.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

     private SimpleIntegerProperty id;
     private SimpleStringProperty name;

    public Artist() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    public int getId() { return id.get(); }

    public void setId(int id) { this.id.set(id); }

    //task.setOnSucceded(e->artistTable.getItems().setAll(artistResults);


    public String getName() { return name.get(); }

    public void setName(String name) { this.name.set(name); }
}
