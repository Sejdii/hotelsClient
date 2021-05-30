package com.sadzbr.model;

/**
 * Model dla tabeli rooms
 */
public class Rooms extends Table {
    /**
     * Id hotelu
     */
    private int id_hotel;
    /**
     * Liczba miejsc
     */
    private int nr_of_places;
    /**
     * Cena
     */
    private double price;
    /**
     * Numer pokoju
     */
    private int room_nr;

    {
        tableName = "Rooms";
    }

    /**
     * Pobiera id hotelu
     * @return id hotelu
     */
    public int getId_hotel() {
        return id_hotel;
    }

    /**
     * Ustawia id hotelu
     * @param id_hotel id hotelu
     */
    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    /**
     * Pobiera liczbę miejsc
     * @return liczba miejsc
     */
    public int getNr_of_places() {
        return nr_of_places;
    }

    /**
     * Ustawia liczbę miejsc
     * @param nr_of_places Liczba miejsc
     */
    public void setNr_of_places(int nr_of_places) {
        this.nr_of_places = nr_of_places;
    }

    /**
     * Pobiera cenę
     * @return cena
     */
    public double getPrice() {
        return price;
    }

    /**
     * Ustawia cenę
     * @param price cena
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Pobiera numer pokoju
     * @return numer pokoju
     */
    public int getRoom_nr() {
        return room_nr;
    }

    /**
     * Ustawia numer pokoju
     * @param room_nr numer pokoju
     */
    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

}
