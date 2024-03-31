module com.example.musicui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.musicui to javafx.fxml;
    opens com.example.musicui.model;
    exports com.example.musicui;
}