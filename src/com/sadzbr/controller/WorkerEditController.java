package com.sadzbr.controller;

import com.sadzbr.model.Table;
import com.sadzbr.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WorkerEditController implements Initializable {
    @FXML private TableView workerTable;

    public void handleAddNewButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEditForm");
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
        User user = new User();
        List<Table> userList = user.selectAll();
        ObservableList<User> observableList = FXCollections.observableArrayList();
        for(Table element : userList) {
            observableList.add((User) element);
        }
        workerTable.setItems(observableList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn idColumn = new TableColumn("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        idColumn.setMinWidth(100);

        TableColumn idHotelColumn = new TableColumn("ID hotelu");
        idHotelColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id_hotel"));
        idHotelColumn.setMinWidth(100);

        TableColumn loginColumn = new TableColumn("Login");
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        loginColumn.setMinWidth(100);

        TableColumn userTypeColumn = new TableColumn("Typ użytkownika");
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("user_type"));
        userTypeColumn.setMinWidth(100);

        workerTable.getColumns().addAll(idColumn, idHotelColumn, loginColumn, userTypeColumn);
    }
}
