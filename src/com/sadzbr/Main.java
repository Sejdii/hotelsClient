package com.sadzbr;

import com.sadzbr.controller.SceneController;
import com.sadzbr.utils.Resource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Resource.view("loginPanel")));

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Sieć hoteli - projekt JAVA");
        stage.setMinHeight(600);
        stage.setMinWidth(900);
        stage.setScene(scene);
        stage.show();

        SceneController sceneController = SceneController.getInstance();
        sceneController.setMain(scene);
        sceneController.addScene("loginPanel", FXMLLoader.load(getClass().getResource(Resource.view("loginPanel"))));
        sceneController.addScene("admin/adminChooseAction", FXMLLoader.load(getClass().getResource(Resource.view("admin/adminChooseAction"))));
        sceneController.addScene("admin/workerEdit", FXMLLoader.load(getClass().getResource(Resource.view("admin/workerEdit"))));
        sceneController.addScene("admin/hotelEdit", FXMLLoader.load(getClass().getResource(Resource.view("admin/hotelEdit"))));
        sceneController.addScene("admin/packageEdit", FXMLLoader.load(getClass().getResource(Resource.view("admin/packageEdit"))));
        sceneController.addScene("admin/roomEdit", FXMLLoader.load(getClass().getResource(Resource.view("admin/roomEdit"))));
        sceneController.addScene("worker/reservationA", FXMLLoader.load(getClass().getResource(Resource.view("worker/reservationA"))));
        sceneController.addScene("worker/reservationB", FXMLLoader.load(getClass().getResource(Resource.view("worker/reservationB"))));
        sceneController.addScene("worker/reservationC", FXMLLoader.load(getClass().getResource(Resource.view("worker/reservationC"))));

        sceneController.activate("loginPanel");

        /* SCENE CONTROL TOOL WINDOW */

        Parent toolRoot = FXMLLoader.load(getClass().getResource(Resource.view("sceneControlTool")));
        Scene toolScene = new Scene(toolRoot, 300, 200);

        Stage toolStage = new Stage();
        toolStage.setTitle("SCENE CONTROL TOOL");
        toolStage.setMaxHeight(200);
        toolStage.setMaxWidth(300);
        toolStage.setScene(toolScene);
        toolStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}