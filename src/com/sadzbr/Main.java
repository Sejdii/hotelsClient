package com.sadzbr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/view/login_panel.fxml"));

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Zaloguj się");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
