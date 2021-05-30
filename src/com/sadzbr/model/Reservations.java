package com.sadzbr.model;

import java.time.LocalDate;
import java.util.Date;

public class Reservations extends Table {
    private int id_room;
    private int id_package;
    private int id_payment;
    private int id_client;
    private Date date_start;
    private Date date_end;

    {
        tableName = "Reservations";
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

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

}
