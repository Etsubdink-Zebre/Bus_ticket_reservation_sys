package com.example.bus_ticket_reservation_sys;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    Dbconnection dbc = new Dbconnection();
    Connection c = dbc.conMethod();
    Alert al;
ObservableList<Table1>oblist=FXCollections.observableArrayList();
    ObservableList<Table2>oblist2=FXCollections.observableArrayList();







    private Button addbut;
    @FXML
    private TableColumn<Table1, String> arrivaltime;
    @FXML
    private TextField arrivaltxt;
    @FXML
    private TableColumn<Table2, String> email;

    @FXML
    private TableColumn<Table2, String> name;

    @FXML
    private TableColumn<Table2, String> phoneno;
    @FXML
    private TableColumn<Table2, String> username;

    @FXML
    private TableColumn<Table1,String> bus;

    @FXML
    private TextField bustxt;

    @FXML
    private TableColumn<Table1, String> deptime;

    @FXML
    private TextField deptxt;

    @FXML
    private TableColumn<Table1, String> price;

    @FXML
    private TextField pricetxt;

    @FXML
    private Button logoutbut;


    @FXML
    private TableView<Table1> table;

    @FXML
    private TableView<Table2> tableuser;

    @FXML
    void add(ActionEvent event) throws SQLException {
        String query = ("insert into BUS_SCHEDULE(BUS,DEP_TIME,ARRIVAL_TIME,PRICE) values(?,?,?,?)");
        PreparedStatement pst = c.prepareStatement(query);
        try {
            pst.setString(1, bustxt.getText());
            pst.setString(2, deptxt.getText());
            pst.setString(3, arrivaltxt.getText());
            pst.setString(4, pricetxt.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "insertion done!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @FXML
    void logoutbut(ActionEvent event) {
        Stage stage = (Stage) logoutbut.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dbconnection dbc = new Dbconnection();
        Connection c = dbc.conMethod();

        String query="select BUS,DEP_TIME,ARRIVAL_TIME,PRICE from BUS_SCHEDULE";
        try {
            Statement st = c.createStatement();
            ResultSet rs= st.executeQuery(query);

            while(rs.next()){
               oblist.add(new Table1(rs.getString("BUS"),rs.getString("DEP_TIME"),rs.getString("ARRIVAL_TIME"),rs.getString("PRICE")));

                   }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         bus.setCellValueFactory(new PropertyValueFactory<>("bus"));
        deptime.setCellValueFactory(new PropertyValueFactory<>("deptime"));
        arrivaltime.setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(oblist);

        String q="select NAME,PHONE_NO,EMAIL,USERNAME from REGISTER";
        try {
            Statement st = c.createStatement();
            ResultSet rs= st.executeQuery(q);

            while(rs.next()){
                oblist2.add(new Table2(rs.getString("NAME"),rs.getString("PHONE_NO"),rs.getString("EMAIL"),rs.getString("USERNAME")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneno.setCellValueFactory(new PropertyValueFactory<>("phoneno"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        tableuser.setItems(oblist2);
    }

}
























