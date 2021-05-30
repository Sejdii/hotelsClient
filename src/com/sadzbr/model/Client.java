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

    /**
     * Pobiera nazwisko
     * @return nazwisko
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Ustawia nazwisko
     * @param surname nazwisko
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Pobiera ulicę
     * @return Ulica
     */
    public String getStreet() {
        return street;
    }

    /**
     * Ustawia ulicę
     * @param street Ulica
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Pobiera numer domu
     * @return Numer domu
     */
    public int getHome_nr() {
        return home_nr;
    }

    /**
     * Ustawia numer domu
     * @param home_nr Numer domu
     */
    public void setHome_nr(int home_nr) {
        this.home_nr = home_nr;
    }

    /**
     * Pobiera numer mieszkania
     * @return Numer mieszkania
     */
    public int getFlat_nr() {
        return flat_nr;
    }

    /**
     * Ustawia numer mieszkania
     * @param flat_nr numer mieszkania
     */
    public void setFlat_nr(int flat_nr) {
        this.flat_nr = flat_nr;
    }

    /**
     * Pobiera kod pocztowy
     * @return Kod pocztowy
     */
    public String getZip_code() {
        return zip_code;
    }

    /**
     * Ustawia kod pocztowy
     * @param zip_code Kod pocztowy
     */
    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    /**
     * Pobiera miasto
     * @return miasto
     */
    public String getCity() {
        return city;
    }

    /**
     * Ustawia miasto
     * @param city miasto
     */
    public void setCity(String city) {
        this.city = city;
    }

}
