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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    private TextField username;
    @FXML
    private ComboBox<String> selcetbbutt;
    @FXML
    private TableColumn<Table1, String> id;
    @FXML
    private TableView<Table1> table;
    @FXML
    private Button bookbutt;
    @FXML
    private ComboBox<String> fromch;


    @FXML
    private ComboBox<String> depc;

    @FXML
    private TextField select;


   @FXML
    void back(ActionEvent event) throws IOException {

       FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("log.fxml"));
       Scene scene = new Scene(fxmlLoader.load(), 584, 417);
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

        String user=username.getText();
        String c1=fromch.getValue();
        String c2=depc.getValue();
        String c3=selcetbbutt.getValue();


  try{
      String sql="insert into VIEW2 values('"+user+"','"+c3+"','"+c2+"','"+c1+"')";
     PreparedStatement ps = c.prepareStatement(sql);
     ps.executeQuery();
      JOptionPane.showMessageDialog(null,"booking successfull!!!!");
  }catch (Exception e){
      JOptionPane.showMessageDialog(null,e);
  }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dbconnection dbc = new Dbconnection();
        Connection c = dbc.conMethod();

        String query = "select BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY,ID from BUS_SCHEDULE";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oblist3.add(new Table1(rs.getString("BUS"), rs.getString("DEP_TIME"), rs.getString("ARRIVAL_TIME"), rs.getString("PRICE"),  rs.getString("FROM_CITY") ,rs.getString("TO_CITY"),rs.getString("ID")   ));

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
        table.setItems(oblist3);
populate1();
  populate();
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
    public void populate(){
        ResultSet rs;
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        String sql = "select FROM_CITY,DEP_TIME from BUS_SCHEDULE";

        try{
            rs= c.createStatement().executeQuery(sql);
            while (rs.next()){

                list.add(rs.getString(1));
                list2.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fromch.setItems(list);
        depc.setItems(list2);
    }

    @FXML
    void select(ActionEvent event) {

    }


    public void username(ActionEvent actionEvent) throws SQLException {
        String query = ("insert into VIEW1(USERNAME) values(?)");
        PreparedStatement pst = c.prepareStatement(query);
        try {
            pst.setString(1, username.getText());
    }catch (Exception e) {
            e.printStackTrace();
        }
    }

  public void refreshTable(){
      oblist3.clear();
      ObservableList ll = FXCollections.observableArrayList();
      try {
          String query = "select BUS,DEP_TIME,ARRIVAL_TIME,PRICE,FROM_CITY,TO_CITY,ID from BUS_SCHEDULE where FROM_CITY = '"+fromch.getSelectionModel().getSelectedItem()+"'";

          Statement st = c.createStatement();
          ResultSet rs = st.executeQuery(query);

          while (rs.next()) {
              oblist3.add(new Table1(rs.getString("BUS"), rs.getString("DEP_TIME"), rs.getString("ARRIVAL_TIME"), rs.getString("PRICE"),  rs.getString("FROM_CITY") ,rs.getString("TO_CITY"), rs.getString("Id")));
ll.add(rs.getString("BUS"));
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
      table.setItems(oblist3);
     selcetbbutt.setItems(ll);
  }
    @FXML
    void fromch(ActionEvent event) throws SQLException {
refreshTable();
    }
    @FXML
    void depc(ActionEvent event) {

    }



}
