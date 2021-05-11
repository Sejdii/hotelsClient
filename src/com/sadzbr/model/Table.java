package com.sadzbr.model;

import java.io.Serializable;
import java.util.List;

public abstract class Table implements Serializable {
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
    abstract public List<Table> selectAll();
}
