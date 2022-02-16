package com.example.bus_ticket_reservation_sys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    Dbconnection dbc = new Dbconnection();
    Connection c = dbc.conMethod();


PreparedStatement pst=null;
ResultSet rs=null;
Statement st=null;
String from_c=null;
    String to_c=null;
    @FXML
    private Button back;

    @FXML
    private Button exitbutt;



    @FXML
    private ComboBox<String> fromc;


    @FXML
    private ComboBox<String> toc;

    @FXML
    private TableView<Table1> table;
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
    /*@FXML
    void findbus(ActionEvent event) throws IOException {
        String cond = "select FROM_CITY,TO_CITY from BUS_SCHEDULE where FROM_CITY='" + fromc.getSelectionModel().getSelectedItem() + "' and TO_CITY='" + toc.getSelectionModel().getSelectedItem() + "' ";
        try {
            ResultSet r = c.createStatement().executeQuery(cond);
            while (r.next()) {
                FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("schedule.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 783, 400);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/




    @FXML
    void fromch(ActionEvent event) throws SQLException {


    }
    @FXML
    void toch(ActionEvent event) {

    }
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        populate();

    }

    public void populate(){
     ResultSet rs;
     ObservableList<String> list = FXCollections.observableArrayList();
     ObservableList<String> list2 = FXCollections.observableArrayList();
     String sql = "select FROM_CITY,TO_CITY from BUS_SCHEDULE";
     try{
         rs= c.createStatement().executeQuery(sql);
         while (rs.next()){

            list.add(rs.getString(1));
             list2.add(rs.getString(2));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     fromc.setItems(list);
     toc.setItems(list2);
 }
}