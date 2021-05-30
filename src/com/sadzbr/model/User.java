package com.sadzbr.model;

/**
 * Model dla tabeli user
 */
public class User extends Table {
    /**
     * Id hotel
     */
    private int id_hotel;
    /**
     * Login
     */
    private String login;
    /**
     * Hasło
     */
    private String password;
    /**
     * Typ użytkownika
     */
    private String user_type;

    {
        tableName = "User";
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
     * Pobiera login
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Ustawia login
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Pobiera hasło
     * @return hasło
     */
    public String getPassword() {
        return password;
    }

    /**
     * Ustawia hasło
     * @param password hasło
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Pobiera typ użytkownika
     * @return typ użytkownika
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * Ustawia typ użytkownika
     * @param user_type typ użytkownika
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
