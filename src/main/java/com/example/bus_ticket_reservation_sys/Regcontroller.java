package com.example.bus_ticket_reservation_sys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Regcontroller {
Dbconnection dbc = new Dbconnection();
Connection c = dbc.conMethod();
    @FXML
    private Button backbtn;

    @FXML
    private TextField email;

    @FXML
    private Button exitbtn;

    @FXML
    private TextField name;

    @FXML
    private PasswordField passfield;

    @FXML
    private TextField pn;

    @FXML
    private Button submitbtn;

    @FXML
    private TextField username;

    @FXML
    void backmeth(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void exitmet(ActionEvent event) {
        Stage stage = (Stage) exitbtn.getScene().getWindow();
        stage.close();


    }

    @FXML
    void submitmet(ActionEvent event) throws SQLException {
String query = ("insert into Register(NAME,PHONE_NO,EMAIL,USERNAME,PASSWORD) values(?,?,?,?,?)");
        PreparedStatement pst = c.prepareStatement(query);
        try{
            pst.setString(1,name.getText());
            pst.setString(2,pn.getText());
            pst.setString(3,email.getText());
            pst.setString(4,username.getText());
            pst.setString(5,passfield.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"insertion done!!!");
            FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
