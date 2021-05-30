package com.sadzbr.model;

/**
 * Model dla tabeli Client
 */
public class Client extends Table {
    /**
     * Imię
     */
    private String name;
    /**
     * Nazwisko
     */
    private String surname;
    /**
     * Ulica
     */
    private String street;
    /**
     * Numer domu
     */
    private int home_nr;
    /**
     * Numer mieszkania
     */
    private int flat_nr;
    /**
     * Kod pocztowy
     */
    private String zip_code;
    /**
     * Miasto
     */
    private String city;

    {
        tableName = "Client";
    }

    /**
     * Pobiera imię
     * @return Imię
     */
    public String getName() {
        return name;
    }

    /**
     * Ustawia imię
     * @param name imię
     */
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

}
