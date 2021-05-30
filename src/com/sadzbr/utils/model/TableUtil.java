package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.Message;
import com.sadzbr.model.Package;
import com.sadzbr.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TableUtil <T extends Table> {
    private final Supplier<T> supplier;

    public TableUtil(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public List<Table> getList() {
        String tableName = createContents().getTableName();
        Message message = new Message("get"+tableName+"List", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    public ObservableList<T> convertToObservableList(List<Table> tableList) {
        ObservableList<T> returnList = FXCollections.observableArrayList();
        for(Table t : tableList) {
            returnList.add((T) t);
        }
        return returnList;
    }

    public T getByID(List<Table> tableList, int id) {
        for(Table t : tableList) {
            T x = (T) t;
            if(t.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public T insertList(T x) {
        Message message = new Message("insert"+x.getTableName()+"List", x);
        ServerConnection serverConnection = new ServerConnection();
        List<Table> tableList = serverConnection.sendMessage(message);
        if(tableList == null || tableList.isEmpty()) return null;

        return (T) tableList.get(0);
    }

    public T createContents() {
        return supplier.get();
    }
}
