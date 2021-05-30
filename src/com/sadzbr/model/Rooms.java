package com.sadzbr.model;

public class Rooms extends Table {
    private int id_hotel;
    private int nr_of_places;
    private double price;
    private int room_nr;

    {
        tableName = "Rooms";
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getNr_of_places() {
        return nr_of_places;
    }

    public void setNr_of_places(int nr_of_places) {
        this.nr_of_places = nr_of_places;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoom_nr() {
        return room_nr;
    }

    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

}
