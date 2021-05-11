package com.sadzbr.model;

import java.util.List;

public class Client extends Table {
    private String name;
    private String surname;
    private String street;
    private int home_nr;
    private int flat_nr;
    private String zip_code;
    private String city;

    {
        tableName = "client";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome_nr() {
        return home_nr;
    }

    public void setHome_nr(int home_nr) {
        this.home_nr = home_nr;
    }

    public int getFlat_nr() {
        return flat_nr;
    }

    public void setFlat_nr(int flat_nr) {
        this.flat_nr = flat_nr;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
