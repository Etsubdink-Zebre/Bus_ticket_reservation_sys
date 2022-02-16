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

import javax.security.auth.Refreshable;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    Dbconnection dbc = new Dbconnection();
    Connection c = dbc.conMethod();
    PreparedStatement pst;
    Alert al;
    ObservableList<Table1> oblist = FXCollections.observableArrayList();
    ObservableList<Table2> oblist2 = FXCollections.observableArrayList();

    @FXML
    private Button addbut;
    @FXML
    private TableColumn<Table1, String> arrivaltime;
    @FXML
    private TableColumn<Table2, String> email;
    @FXML
    private TableColumn<Table2, String> name;
    @FXML
    private TableColumn<Table2, String> phoneno;
    @FXML
    private TableColumn<Table2, String> username;

    @FXML
    private TableColumn<Table1, String> bus;
    @FXML

    private TableColumn<Table1, String> deptime;
    @FXML
    private TableColumn<Table1, String> price;
    @FXML
    private TableColumn<Table1, String> fromc;
    @FXML
    private TableColumn<Table1, String> toc;
    @FXML
    private TableColumn<Table1, String> id;
    @FXML
    private TextField arrivaltxt;

    @FXML
    private TextField bustxt;
    @FXML
    private TextField fromtxt;
    @FXML
    private TextField totxt;
    @FXML
    private Button next;

    @FXML
    private TextField deptxt;

    @FXML
    private TextField pricetxt;
    @FXML
    private Button logoutbut;
    @FXML
    private TextField idtxt;
    @FXML
    private Button deletbut;
    @FXML
    private TableView<Table1> table;

    @FXML
    private TableView<Table2> tableuser;

    @FXML
    void add(ActionEvent event) throws SQLException {
        String query = ("insert into BUS_SCHEDULE(BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY,ID) values(?,?,?,?,?,?,?)");
        PreparedStatement pst = c.prepareStatement(query);
        try {
            pst.setString(1, bustxt.getText());
            pst.setString(2, deptxt.getText());
            pst.setString(3, arrivaltxt.getText());
            pst.setString(4, pricetxt.getText());
            pst.setString(5, fromtxt.getText());
            pst.setString(6, totxt.getText());
            pst.setString(7, idtxt.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "insertion done!!!");
            refreshTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void next(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 798, 457);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    void delete(ActionEvent event) {

       String lbl1 = idtxt.getText();
        String sql = "delete from BUS_SCHEDULE where Id= '"+lbl1+"'";
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

    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
public void refreshTable(){
        oblist.clear();
    try {
        String query = "select BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY,ID from BUS_SCHEDULE";

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            oblist.add(new Table1(rs.getString("BUS"), rs.getString("DEP_TIME"), rs.getString("ARRIVAL_TIME"), rs.getString("PRICE"),  rs.getString("FROM_CITY") ,rs.getString("TO_CITY"), rs.getString("Id")));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    bus.setCellValueFactory(new PropertyValueFactory<>("bus"));
    deptime.setCellValueFactory(new PropertyValueFactory<>("deptime"));
    arrivaltime.setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    fromc.setCellValueFactory(new PropertyValueFactory<>("fromc"));
    toc.setCellValueFactory(new PropertyValueFactory<>("toc"));
    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    table.setItems(oblist);
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dbconnection dbc = new Dbconnection();
        Connection c = dbc.conMethod();

        String query = "select BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY,ID from BUS_SCHEDULE";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oblist.add(new Table1(rs.getString("BUS"), rs.getString("DEP_TIME"), rs.getString("ARRIVAL_TIME"), rs.getString("PRICE"),  rs.getString("FROM_CITY") ,rs.getString("TO_CITY"), rs.getString("ID")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bus.setCellValueFactory(new PropertyValueFactory<>("bus"));
        deptime.setCellValueFactory(new PropertyValueFactory<>("deptime"));
        arrivaltime.setCellValueFactory(new PropertyValueFactory<>("arrivaltime"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        fromc.setCellValueFactory(new PropertyValueFactory<>("fromc"));
        toc.setCellValueFactory(new PropertyValueFactory<>("toc"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
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

