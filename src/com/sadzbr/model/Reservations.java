package com.sadzbr.model;

import java.util.Date;

/**
 * Model dla tabeli reservations
 */
public class Reservations extends Table {
    /**
     * Id pokoju
     */
    private int id_room;
    /**
     * Id pakietu
     */
    private int id_package;
    /**
     * Id płatności
     */
    private int id_payment;
    /**
     * Id klienta
     */
    private int id_client;
    /**
     * Data początku rezerwacji
     */
    private Date date_start;
    /**
     * Data końca rezerwacji
     */
    private Date date_end;

    {
        tableName = "Reservations";
    }

    /**
     * Pobiera id pokoju
     * @return id pokoju
     */
    public int getId_room() {
        return id_room;
    }

    /**
     * Ustawia id pokoju
     * @param id_room id pokoju
     */
    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    /**
     * Pobiera id pakietu
     * @return id pakietu
     */
    public int getId_package() {
        return id_package;
    }

    /**
     * Ustawia id pakietu
     * @param id_package id pakietu
     */
    public void setId_package(int id_package) {
        this.id_package = id_package;
    }

    /**
     * Pobiera id płatności
     * @return id płatności
     */
    public int getId_payment() {
        return id_payment;
    }

    /**
     * Ustawia id płatności
     * @param id_payment id płatności
     */
    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    /**
     * Pobiera id klienta
     * @return id klienta
     */
    public int getId_client() {
        return id_client;
    }

    /**
     * Ustawia id klienta
     * @param id_client id klienta
     */
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    /**
     * Pobiera datę początku rezerwacji
     * @return data początku rezerwacji
     */
    public Date getDate_start() {
        return date_start;
    }

    /**
     * Ustawia datę początku rezerwacji
     * @param date_start data początku rezerwajci
     */
    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    /**
     * Pobiera datę końca rezerwacji
     * @return data końca rezerwacji
     */
    public Date getDate_end() {
        return date_end;
    }

    /**
     * Ustawia datę końca rezerwacji
     * @param date_end data końca rezerwacji
     */
    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

}
