package com.sadzbr.model;

import java.util.List;

public class Payments extends Table {
    private String form;
    private double amount;

    {
        tableName = "payments";
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


    @Override
    public int insert() {
        return 0;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean select() {
        return false;
    }

    @Override
    public List<Table> selectAll() {
        return null;
    }
}
