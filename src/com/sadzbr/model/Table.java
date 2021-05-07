package com.sadzbr.model;

public abstract class Table {
    protected String tableName;
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    abstract public int insert();
    abstract public boolean update();
    abstract public boolean delete();
    abstract public boolean select();
}
