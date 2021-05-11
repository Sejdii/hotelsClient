package com.sadzbr.model;

import java.util.List;

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

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean select() {
        return false;
    }

    @Override
    public List<Table> selectAll() {
        return null;
    }
}
