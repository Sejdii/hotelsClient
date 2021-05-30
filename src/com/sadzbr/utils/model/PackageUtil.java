package com.sadzbr.utils.model;

import com.sadzbr.controller.ServerConnection;
import com.sadzbr.model.*;
import com.sadzbr.model.Package;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

public class PackageUtil {
    static public List<Table> getPackageList() {
        Message message = new Message("getPackageList", null);
        ServerConnection serverConnection =  new ServerConnection();
        return serverConnection.sendMessage(message);
    }

    static public ObservableList<Package> convertToObservableList(List<Table> tableList) {
        ObservableList<Package> returnList = FXCollections.observableArrayList();
        for(Table t : tableList) {
            returnList.add((Package) t);
        }
        return returnList;
    }

    static public Package insertPackageList(Package p) {
        Message message = new Message("insertPackageList", p);
        ServerConnection serverConnection = new ServerConnection();
        List<Table> tableList = serverConnection.sendMessage(message);
        if(tableList == null || tableList.isEmpty()) return null;

        return (Package) tableList.get(0);
    }

    static public void updatePackageList(Package p) {
        Message message = new Message("updatePackageList", p);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

    static public List<Table> excludeByHotelId(List<Table> tableList, int idHotel) {
        List<Table> retList = new ArrayList<>();
        for(Table t : tableList) {
            Package p = (Package) t;
            if(p.getId_hotel() == idHotel) {
                retList.add(p);
            }
        }
        return retList;
    }

    static public void deletePackageList(Package p) {
        Message message = new Message("deletePackageList", p);
        ServerConnection serverConnection = new ServerConnection();
        serverConnection.sendMessage(message);
    }

    static public ComboBox<Package> setCombobox(ComboBox<Package> comboBox, List<Table> tableList) {
        ObservableList<Package> packages = convertToObservableList(tableList);
        comboBox.setItems(packages);
        comboBox.setValue((Package) tableList.get(0));
        comboBox.setConverter(new StringConverter<Package>() {
            @Override
            public String toString(Package object) {
                return object.getName();
            }

            @Override
            public Package fromString(String string) {
                return null;
            }
        });
        return comboBox;
    }
}
