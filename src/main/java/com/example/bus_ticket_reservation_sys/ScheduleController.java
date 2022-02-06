package com.example.bus_ticket_reservation_sys;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

    @FXML
    private Button backbut;

    @FXML
    private Button exitbut;

    @FXML
   private ComboBox<String> selcetbbutt;

    @FXML
    private TableView<?> table;
    @FXML
    private Button bookbutt;

    @FXML
    private TextField select;


    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("book.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) exitbut.getScene().getWindow();
        stage.close();
    }



    @FXML
    void book(ActionEvent event) throws IOException {
        JOptionPane.showMessageDialog(null,"booking successfull!!!!");
                back(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selcetbbutt.setItems(FXCollections.observableArrayList("Sheger", "Selam","Golden","Ethio"));
    }
    @FXML
    void select(ActionEvent event) {

    }


}