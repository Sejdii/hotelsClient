package com.sadzbr.model;

import java.io.Serializable;

/**
 * Abstrakcyjna klasa będąca modelem dla dowolnej tabeli
 */
public abstract class Table implements Serializable {
    /**
     * Nazwa tabeli
     */
    protected String tableName;
    /**
     * ID
     */
    protected int id;

    /**
     * Pobiera id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Ustawia id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Pobiera nazwę tabeli
     * @return Nazwa tabeli
     */
    public String getTableName() {
        return tableName;
    }
}
