package com.sadzbr.model;

import java.util.List;

public class Reservations extends Table {
    private int id_room;
    private int id_package;
    private int id_payment;
    private int id_client;

    {
        tableName = "reservations";
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_package() {
        return id_package;
    }

    public void setId_package(int id_package) {
        this.id_package = id_package;
    }

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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
