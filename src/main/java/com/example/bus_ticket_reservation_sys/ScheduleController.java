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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {
Dbconnection db = new Dbconnection();
Connection c = db.conMethod();
    ObservableList<Table1> oblist3=FXCollections.observableArrayList();
    ResultSet rs=null;
    @FXML
    private Button backbut;
    @FXML
    private TableColumn<Table1, String> arrivaltime;
    @FXML
    private TableColumn<Table1,String> bus;
    @FXML
    private TableColumn<Table1, String> deptime;
    @FXML
    private TableColumn<Table1, String> price;
    @FXML
    private TableColumn<Table1, String> fromc;
    @FXML
    private TableColumn<Table1, String> toc;
    @FXML
    private Button exitbut;

    @FXML
    private ComboBox<String> selcetbbutt;

    @FXML
    private TableView<Table1> table;
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
        Dbconnection dbc = new Dbconnection();
        Connection c = dbc.conMethod();

        String query = "select BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY from BUS_SCHEDULE";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oblist3.add(new Table1(rs.getString("BUS"), rs.getString("DEP_TIME"), rs.getString("ARRIVAL_TIME"), rs.getString("PRICE"),  rs.getString("FROM_CITY") ,rs.getString("TO_CITY")  ));

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
        table.setItems(oblist3);
populate1();
        }

   public void populate1() {
       ResultSet rs=null;
       Statement st=null;




       ObservableList<String> list = FXCollections.observableArrayList();

       String sql = "select BUS from BUS_SCHEDULE";
       try{
           rs= c.createStatement().executeQuery(sql);
           while (rs.next()){

               list.add(rs.getString(1));

           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       selcetbbutt.setItems(list);
   }


    @FXML
    void select(ActionEvent event) {

    }


}
