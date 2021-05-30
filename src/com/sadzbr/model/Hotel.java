package com.sadzbr.model;

/**
 * Model tabeli Hotel
 */
public class Hotel extends Table {
    /**
     * Adres
     */
    private String address;
    /**
     * Nazwa
     */
    private String name;

    {
        tableName = "Hotel";
    }

    /**
     * Pobiera adres
     * @return Adres
     */
    public String getAddress() {
        return address;
    }

    /**
     * Ustawia adres
     * @param address Adres
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Pobiera nazwę
     * @return Nazwa
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia nazwę
     * @param name Nazwa
     */
    public void setName(String name) {
        this.name = name;
    }

}
