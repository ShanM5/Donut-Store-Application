package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void openDonutMenu() throws IOException {
        //opens the donut menu stage
        FXMLLoader loaderDonutMenu = new FXMLLoader(getClass().getResource("OrderingDonutsView.fxml"));
        Parent r = loaderDonutMenu.load();
        Stage donutMenu = new Stage();
        donutMenu.setScene(new Scene(r));
        donutMenu.show();

    }
    @FXML
    protected void openCoffeeMenu() throws IOException {
        //opens the coffee menu stage
        FXMLLoader loaderDonutMenu = new FXMLLoader(getClass().getResource("OrderingCoffeeView.fxml"));
        Parent r = loaderDonutMenu.load();
        Stage donutMenu = new Stage();
        donutMenu.setScene(new Scene(r));
        donutMenu.show();
    }

    @FXML
    protected void openOrderingBasketMenu() throws IOException {
        //opens the ordering basket menu stage
        FXMLLoader loaderDonutMenu = new FXMLLoader(getClass().getResource("OrderingBasketView.fxml"));
        Parent r = loaderDonutMenu.load();
        Stage donutMenu = new Stage();
        donutMenu.setScene(new Scene(r));
        donutMenu.show();

    }
    @FXML
    protected void openStoreOrdersMenu() throws IOException {
        //opens the store order menu
        FXMLLoader loaderDonutMenu = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent r = loaderDonutMenu.load();
        Stage donutMenu = new Stage();
        donutMenu.setScene(new Scene(r));
        donutMenu.show();
    }

}