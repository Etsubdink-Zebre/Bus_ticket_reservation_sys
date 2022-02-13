package com.example.bus_ticket_reservation_sys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BusApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 584, 417);
        stage.setTitle("Bus ticket reservation system!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}