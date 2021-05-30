package com.sadzbr.model;

/**
 * Model dla tabeli package
 */
public class Package extends Table {
    /**
     * Id hotelu
     */
    private int id_hotel;
    /**
     * Cena
     */
    private double price;
    /**
     * Nazwa
     */
    private String name;
    /**
     * Opis
     */
    private String description;

    {
        tableName = "Package";
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
     * Pobiera nazwę
     * @return nazwa
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwę
     * @param name nazwa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Pobiera opis
     * @return opis
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis
     * @param description opis
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
