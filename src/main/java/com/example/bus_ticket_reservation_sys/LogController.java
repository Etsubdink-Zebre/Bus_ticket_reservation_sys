package com.example.bus_ticket_reservation_sys;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogController {
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
    private Button cancelbutt;

    @FXML
    private CheckBox showpwdbutt;
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
                            FXMLLoader fxmlLoader = new FXMLLoader(BusApplication.class.getResource("book.fxml"));
                            Scene scene=new Scene(fxmlLoader.load(),600,400);
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
    void showpwd(ActionEvent event) {
/*showpwdbutt.selectedProperty().addListener((ObservableListValue<?extends>,Boolean old val,Boolean));
     if(showpwdbutt.isSelected(){
         showpwdbutt.setText(pwd1.getText());
         showpwdbutt.setVisible(true);
         pwd1.setVisible(false);
     }pwd1.setText(showpwdbutt.getText());
     pwd1.setVisible(true);
     showpwdbutt.setVisible(false);});*/


    }
}
