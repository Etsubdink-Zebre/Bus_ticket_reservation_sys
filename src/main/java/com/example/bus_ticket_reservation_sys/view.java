package com.example.bus_ticket_reservation_sys;

public class view {
    String username, bus, deptime, fromc;

    public view(String username, String bus, String deptime, String fromc) {
        this.username = username;
        this.bus = bus;
        this.deptime = deptime;
        this.fromc = fromc;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }


    public String getFromc() {
        return fromc;
    }

    public void setFromc(String fromc) {
        this.fromc = fromc;
    }
}

