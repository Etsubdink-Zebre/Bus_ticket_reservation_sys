package com.example.bus_ticket_reservation_sys;

public class CityCombo {
    private String fromc;
    private String toc;
    public CityCombo(String fromc, String toc){
        this.fromc=fromc;
        this.toc=toc;
    }
    public String getFromc(){

        return fromc;
    }
    public void setFromc(String fromc){
                this.fromc=fromc;
    }
    public String getToc(){

        return toc;
    }
    public void setToc(String toc){
        this.toc=toc;
    }
}
