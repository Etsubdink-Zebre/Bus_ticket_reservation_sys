package com.example.bus_ticket_reservation_sys;

public class Table2 {
    String  name,phoneno,email,username;
    public Table2(String  name,String phoneno,String email,String username){
        this.name=name;
        this.phoneno=phoneno;
        this.email=email;
        this.username=username;

    }
    public String getName(){
        return name;
    }
    public void setBus(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPhoneno(){
        return phoneno;
    }
    public void setPhoneno(String phoneno){
        this.phoneno=phoneno;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

}
