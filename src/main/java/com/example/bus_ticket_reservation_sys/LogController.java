package com.example.bus_ticket_reservation_sys;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogController implements Initializable {
    Dbconnection db=new Dbconnection();
    Connection con=db.conMethod();

    @FXML
    private Button logbutt;
    @FXML
    private PasswordField pwd1;
    @FXML
    private Button signbutt;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt11;
    @FXML
    private Button cancelbutt;

    @FXML
    private CheckBox showpwdbutt;
    private String password;

    private InvalidationListener ObservableListValue;

    public LogController() throws ClassNotFoundException {
    }


    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        String qq= null;

        String se= "select USERNAME,PASSWORD,ROLL from REGISTER where USERNAME ='" + txt1.getText() + "'";
        try {
            ResultSet res = con.createStatement().executeQuery(se);
            while (res.next()){
                if(txt1.getText().equals(res.getString(1))){
                    if (pwd1.getText().equals(res.getString(2))) {
                        if(res.getString(3).equals("ADMIN")) {
                            FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("admin1.fxml"));
                            Scene scene=new Scene(fxmlLoader.load(),953,655);
                            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setTitle("Bus Ticket Reservation");
                            window.setScene(scene);
                            window.show();
                        }
                        else if(res.getString(3).equals("USER")){
                            FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("schedule.fxml"));
                            Scene scene=new Scene(fxmlLoader.load(),783,400);
                            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setTitle("Bus Ticket Reservation");
                            window.setScene(scene);
                            window.show();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Wrong password");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Username");
                }
            }
        }
        catch (Exception e){
          JOptionPane.showMessageDialog(null,"invalid username");
            e.printStackTrace();
        }
    }




    @FXML
    void cancel(ActionEvent event) {
        txt1.setText("");
        pwd1.setText("");
    }
    @FXML
    void signup(ActionEvent event) throws IOException { FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("reg.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }



    @FXML
    void showP(ActionEvent event) {
        if(showpwdbutt.isSelected()){
            password = pwd1.getText();

            txt11.setPromptText(password);
            txt11.setVisible(true);
            pwd1.setVisible(false);
        }
        else{
            txt11.setVisible(false);
            //  pwd1.setText(txt11.getText());
            pwd1.setVisible(true);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
