package com.sadzbr.model;

import java.io.Serializable;

/**
 * Model wiadomości przesyłanej poprzez socket w komunikacji klient-serwer
 */
public class Message implements Serializable {
    /**
     * Typ operacji
     */
    private final String operationType;
    /**
     * Tabela
     */
    private final Table table;

    /**
     * Konstruktor
     * @param operationType typ operacji
     * @param table tabela
     */
    public Message(String operationType, Table table) {
        this.operationType = operationType;
        this.table = table;
    }

    /**
     * Pobiera typ operacji
     * @return typ operacji
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * Pobiera tabelę
     * @return tabela
     */
    public Table getTable() {
        return table;
    }

}
