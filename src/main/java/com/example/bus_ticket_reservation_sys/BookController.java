package com.example.bus_ticket_reservation_sys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BookController {
    Dbconnection dbc = new Dbconnection();
    Connection c = dbc.conMethod();

    @FXML
    private Button back;

    @FXML
    private Button exitbutt;

    @FXML
    private ComboBox<?> findbus;

    @FXML
    private ComboBox<?> fromc;


    @FXML
    private ComboBox<?> toc;

    @FXML
    private TableView<?> table;
    @FXML
    private Button findbutt;

    @FXML
    void backbutt(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) exitbutt.getScene().getWindow();
        stage.close();

    }
    @FXML
    void findbus(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("schedule.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }




    @FXML
    void fromch(ActionEvent event) {

    }

    @FXML
    void toch(ActionEvent event) {

    }


}