package com.sadzbr.model;

/**
 * Model dla tabeli payments
 */
public class Payments extends Table {
    /**
     * Forma płatności
     */
    private String form;
    /**
     * Kwota
     */
    private double amount;

    {
        tableName = "Payments";
    }

    /**
     * Pobiera formę płatności
     * @return forma płatności
     */
    public String getForm() {
        return form;
    }

    /**
     * Ustawia formę płatności
     * @param form forma płatności
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * Pobiera kwotę
     * @return kwota
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Ustawia kwotę
     * @param amount kwota
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
