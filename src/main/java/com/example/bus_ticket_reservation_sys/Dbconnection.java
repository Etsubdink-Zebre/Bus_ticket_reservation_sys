package com.example.bus_ticket_reservation_sys;
import java.sql.*;
public class Dbconnection {
    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "VERI";
    private static final String PASSWORD = "12345";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    Connection conn = null;
    public Connection conMethod(){
        try {
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}