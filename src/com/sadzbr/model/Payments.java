package com.sadzbr.model;

public class Payments extends Table {
    private String form;
    private double amount;

    {
        tableName = "Payments";
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
