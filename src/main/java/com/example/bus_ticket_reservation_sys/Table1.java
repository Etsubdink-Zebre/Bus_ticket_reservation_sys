package com.example.bus_ticket_reservation_sys;

public class Table1 {
    String  bus,deptime,arrivaltime,price;
    public Table1(String  bus,String deptime,String arrivaltime,String price){
        this.bus=bus;
        this.deptime=deptime;
        this.arrivaltime=arrivaltime;
        this.price=price;

    }
    public String getBus(){
        return bus;
    }
    public void setBus(String bus){
        this.bus=bus;
    }
    public String getArrivaltime(){
        return arrivaltime;
    }
    public void setArrivaltime(String arrivaltime){
        this.arrivaltime=arrivaltime;
    }
    public String getDeptime(){
        return deptime;
    }
    public void setDeptime(String deptime){
        this.deptime=deptime;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }


}
