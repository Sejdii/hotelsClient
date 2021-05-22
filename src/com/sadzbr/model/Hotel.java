package com.sadzbr.model;

public class Hotel extends Table {
    private String address;
    private String name;

    {
        tableName = "hotel";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
