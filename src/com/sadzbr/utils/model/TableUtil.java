package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.function.Supplier;

/**
 * Zawiera uniwersalne metody dla każdej z tabel
 * @param <T> Tabela
 */
public class TableUtil <T extends Table> {
    /**
     * Supplier tabeli
     */
    private final Supplier<T> supplier;

    /**
     * Konstruktor
     * @param supplier supplier
     */
    public TableUtil(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Pobiera listę z danej tabeli
     * @return lista
     */
    public List<Table> getList() {
        String tableName = createContents().getTableName();
        Message message = new Message("get"+tableName+"List", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    /**
     * Konwertuje listę do ObservableList
     * @param tableList lista
     * @return Lista skonwertowana
     */
    public ObservableList<T> convertToObservableList(List<Table> tableList) {
        ObservableList<T> returnList = FXCollections.observableArrayList();
        for(Table t : tableList) {
            returnList.add((T) t);
        }
        return returnList;
    }

    /**
     * Pobiera element z listy po jego ID
     * @param tableList lista
     * @param id ID
     * @return Element
     */
    public T getByID(List<Table> tableList, int id) {
        for(Table t : tableList) {
            T x = (T) t;
            if(t.getId() == id) {
                return x;
            }
        }
        return null;
    }

    /**
     * Realizuje polecenie insert na tabeli
     * @param x Tabela
     * @return Tabela
     */
    public T insertList(T x) {
        Message message = new Message("insert"+x.getTableName()+"List", x);
        ServerConnection serverConnection = new ServerConnection();
        List<Table> tableList = serverConnection.sendMessage(message);
        if(tableList == null || tableList.isEmpty()) return null;

        return (T) tableList.get(0);
    }

    /**
     * Zwraca kontent dla supplier
     * @return Tabela
     */
    public T createContents() {
        return supplier.get();
    }
}
