package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Table;
import com.sadzbr.model.User;
import com.sadzbr.utils.model.UserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Kontroler edycji pracownika
 */
public class WorkerEditController implements Initializable {
    /**
     * Tabela z pracownikami
     */
    @FXML private TableView workerTable;

    /**
     * Handler przycisku dodaj nowego pracownika
     * @param actionEvent Event
     */
    public void handleAddNewButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/workerEditForm");
    }

    /**
     * Handler przycisku odświeżenia
     * @param actionEvent event
     */
    public void handleRefreshButton(ActionEvent actionEvent) {
        List<Table> userList = UserUtil.getUserList();
        ObservableList<User> observableList = FXCollections.observableArrayList();
        for(Table element : userList) {
            observableList.add((User) element);
        }
        workerTable.setItems(observableList);
    }

    /**
     * Inicjator kontrolera. Ustawia tabelę.
     * @param location Lokacja
     * @param resources Zasoby
     */
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

    /**
     * Handler przycisku usunięcia
     * @param actionEvent event
     */
    public void handleDeleteButton(ActionEvent actionEvent) {
        User user = (User) workerTable.getSelectionModel().getSelectedItem();
        if(user != null && user.getId() != 0) { //cannot delete root account
            UserUtil.deleteUserList(user);
            handleRefreshButton(actionEvent);
        }
    }

    /**
     * Handler przycisku edycji
     * @param actionEvent event
     */
    public void handleEditButton(ActionEvent actionEvent) {
        User user = (User) workerTable.getSelectionModel().getSelectedItem();
        if(user != null && user.getId() != 0) {
            SceneController sceneController = SceneController.getInstance();
            FXMLLoader fxmlLoader = sceneController.getLoader("admin/workerEditForm");
            WorkerEditFormController workerEditFormController = fxmlLoader.getController();
            workerEditFormController.setWorkerID(user.getId());
            sceneController.activate("admin/workerEditForm");
        }
    }
}
