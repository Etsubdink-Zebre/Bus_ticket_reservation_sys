package com.example.bus_ticket_reservation_sys;

public class Table1 {
    String  bus,deptime,arrivaltime,price,fromc,toc,id;
    public Table1(String  bus,String deptime,String arrivaltime,String price,String fromc,String toc,String id){
        this.bus=bus;
        this.deptime=deptime;
        this.arrivaltime=arrivaltime;
        this.price=price;
        this.fromc=fromc;
        this.toc=toc;
        this.id=id;

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
    public String getFromc(){return fromc;}
    public void setFromc(String fromc){
        this.fromc=fromc;
    }
    public String getToc(){
        return toc;
    }
    public void setToc(String toc){
        this.toc=toc;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

}