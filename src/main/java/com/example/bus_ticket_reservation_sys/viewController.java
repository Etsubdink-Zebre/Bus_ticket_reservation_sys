package com.example.bus_ticket_reservation_sys;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.EventObject;
import java.util.ResourceBundle;

public class viewController implements Initializable {
    Dbconnection dbc = new Dbconnection();
    Connection c = dbc.conMethod();
    PreparedStatement pst;
    Alert al;
    ObservableList<view> oblist5 = FXCollections.observableArrayList();
    @FXML
    private TableColumn<view, String> deptime;
    @FXML
    private TableColumn<view,String> bus;
    @FXML
    private TableColumn<view, String> username;
    @FXML
    private TableColumn<view, String> fromc;
    @FXML
    private TableView<view> tableview;
    @FXML
    private TextField deptime1;
    @FXML
    private TextField username1;

    @FXML
    private Button delete;
   

    @FXML
    void view(ActionEvent event) {


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dbconnection dbc = new Dbconnection();
        Connection c = dbc.conMethod();

        String query = "select USERNAME,BUS,DEPTIME,FROMCITY from VIEW2";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oblist5.add(new view(rs.getString("USERNAME"), rs.getString("BUS"), rs.getString("DEPTIME"),  rs.getString("FROMCITY")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        bus.setCellValueFactory(new PropertyValueFactory<>("bus"));
        deptime.setCellValueFactory(new PropertyValueFactory<>("deptime"));
        fromc.setCellValueFactory(new PropertyValueFactory<>("fromc"));
        tableview.setItems(oblist5);
}

    public void delete(javafx.event.ActionEvent actionEvent) {

        String lbl1 = username1.getText();
        String lbl2 = deptime1.getText();
        String sql = "delete from VIEW2 where USERNAME= '"+lbl1+"' and DEPTIME='"+lbl2+"'";
        try{ Connection c = dbc.conMethod();
            pst = c.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deleted succsecfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Try again!!");
        }
        refreshTable();
    }
    public void refreshTable(){
        oblist5.clear();
        try {
            String query = "select USERNAME,BUS,DEPTIME,FROMCITY from VIEW2";

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oblist5.add(new view(rs.getString("USERNAME"), rs.getString("BUS"), rs.getString("DEPTIME"),  rs.getString("FROMCITY")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        bus.setCellValueFactory(new PropertyValueFactory<>("bus"));
        deptime.setCellValueFactory(new PropertyValueFactory<>("deptime"));
        fromc.setCellValueFactory(new PropertyValueFactory<>("fromc"));
        tableview.setItems(oblist5);
    }


}