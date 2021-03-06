package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Package;
import com.sadzbr.model.Table;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.PackageUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Kontroler edycji pakietu
 */
public class PackageEditController implements Initializable {
    /**
     * Id hotelu
     */
    @FXML private ComboBox<Hotel> id_hotel;
    /**
     * TableView dla pakietów
     */
    @FXML private TableView<Package> packageTable;

    /**
     * Handler dla przycisku dodaj
     * @param actionEvent event
     */
    public void handleAddNewButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEditForm");
    }

    /**
     * Handler dla przycisku refresh
     * @param actionEvent event
     */
    public void handleRefreshButton(ActionEvent actionEvent) {
        List<Table> packageList = PackageUtil.getPackageList();
        packageList = PackageUtil.excludeByHotelId(packageList, id_hotel.getValue().getId());
        ObservableList<Package> packages = PackageUtil.convertToObservableList(packageList);
        packageTable.setItems(packages);
    }

    /**
     * Handler dla przycisku usuń
     * @param actionEvent event
     */
    public void handleDeleteButton(ActionEvent actionEvent) {
        Package p = packageTable.getSelectionModel().getSelectedItem();
        if(p != null) {
            PackageUtil.deletePackageList(p);
            handleRefreshButton(actionEvent);
        }
    }

    /**
     * Handler dla przycisku edytuj
     * @param actionEvent event
     */
    public void handleEditButton(ActionEvent actionEvent) {
        Package p = packageTable.getSelectionModel().getSelectedItem();
        if(p != null) {
            SceneController sceneController = SceneController.getInstance();
            FXMLLoader fxmlLoader = sceneController.getLoader("admin/packageEditForm");
            PackageEditFormController packageEditFormController = fxmlLoader.getController();
            packageEditFormController.setPackageId(p);
            sceneController.activate("admin/packageEditForm");
        }
    }

    /**
     * Inicjator kontrolera, ustawia kolumny dla tabeli oraz combobox wyboru hotelu
     * @param location Lokacja
     * @param resources Zasoby
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* PREPARE TABLE START ---> */


        TableColumn<Package, Double> priceColumn = new TableColumn<Package, Double>("Cena");
        priceColumn.setCellValueFactory(new PropertyValueFactory<Package, Double>("price"));
        priceColumn.setMinWidth(100);

        TableColumn<Package, String> packageNameColumn = new TableColumn<Package, String>("Nazwa");
        packageNameColumn.setCellValueFactory(new PropertyValueFactory<Package, String>("name"));
        packageNameColumn.setMinWidth(100);

        TableColumn<Package, String> packageDescriptionColumn = new TableColumn<Package, String>("Opis");
        packageDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Package, String>("description"));
        packageDescriptionColumn.setMinWidth(100);

        packageTable.getColumns().addAll(priceColumn, packageNameColumn, packageDescriptionColumn);

        /* <---- PREPARE TABLE END */

        List<Table> tableList = HotelUtil.getHotelList();
        id_hotel = HotelUtil.setCombobox(id_hotel, tableList);
    }
}
