package com.github.eragontuan.cinema_project03_11_2018.Models;

public class Wifi {
    private String Name,Security_key;

    public Wifi() {
    }

    public Wifi(String name, String security_key) {
        Name = name;
        Security_key = security_key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecurity_key() {
        return Security_key;
    }

    public void setSecurity_key(String security_key) {
        Security_key = security_key;
    }
}
