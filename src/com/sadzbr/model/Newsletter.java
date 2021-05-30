package com.sadzbr.model;

/**
 * Model dla tabeli newsletter
 */
public class Newsletter extends Table {
    /**
     * Email
     */
    private String email;
    /**
     * Id klienta
     */
    private int id_client;

    {
        tableName = "Newsletter";
    }

    /**
     * Pobiera email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Ustawia email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
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

}
