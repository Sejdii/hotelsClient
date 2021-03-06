package com.sadzbr.controller.view;

import com.sadzbr.controller.SceneController;
import com.sadzbr.model.Hotel;
import com.sadzbr.model.Package;
import com.sadzbr.utils.model.HotelUtil;
import com.sadzbr.utils.model.PackageUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler formularza edycji pakietu
 */
public class PackageEditFormController implements Initializable {
    /**
     * Id hotelu
     */
    @FXML private ComboBox<Hotel> id_hotel;
    /**
     * Pole cena
     */
    @FXML private TextField price;
    /**
     * Pole nazwa
     */
    @FXML private TextField name;
    /**
     * Pole opis
     */
    @FXML private TextField description;
    /**
     * Id pakietu. Jeżeli ma on wartość -1 oznacza to że dodajemy pakiet a nie edytujemy istniejący
     */
    private int packageId = -1;

    /**
     * Handler przycisku anuluj
     * @param actionEvent event
     */
    public void handleCancelButton(ActionEvent actionEvent) {
        SceneController sceneController = SceneController.getInstance();
        sceneController.activate("admin/packageEdit");
    }

    /**
     * Handler przycisku zapisz
     * @param actionEvent event
     */
    public void handleSaveButton(ActionEvent actionEvent) {
        Package p = new Package();
        p.setId_hotel((id_hotel.getValue()).getId());
        p.setPrice(Double.parseDouble(price.getText()));
        p.setName(name.getText());
        p.setDescription(description.getText());

        if(packageId == -1) { // if is equal -1 we are inserting new package
            PackageUtil.insertPackageList(p);
        } else {
            p.setId(packageId);
            PackageUtil.updatePackageList(p);
        }

        packageId = -1;
        handleCancelButton(actionEvent);
    }

    /**
     * Inicjator kontrolera. Ustawia combobox oraz ustawia pole price.
     * @param location Lokacja
     * @param resources Zasoby
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_hotel = HotelUtil.setCombobox(id_hotel, HotelUtil.getHotelList());

        price.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    price.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * Ustawia ID pakietu
     * @param p Pakiet
     */
    public void setPackageId(Package p) {
        packageId = p.getId();
        Hotel hotel = HotelUtil.getByID(HotelUtil.getHotelList(), p.getId_hotel());
        id_hotel.setValue(hotel);
        price.setText(String.valueOf((int)p.getPrice()));
        name.setText(p.getName());
        description.setText(p.getDescription());
    }
}
