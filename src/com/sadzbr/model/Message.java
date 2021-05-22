package com.sadzbr.model;

import java.io.Serializable;

public class Message implements Serializable {
    private final String operationType;
    private final Table table;

    public Message(String operationType, Table table) {
        this.operationType = operationType;
        this.table = table;
    }

    public String getOperationType() {
        return operationType;
    }

    public Table getTable() {
        return table;
    }

}
