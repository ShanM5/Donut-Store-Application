package com.example.project4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderingCoffeeController {

    @FXML private ComboBox coffeeViewSize;
    @FXML private ComboBox coffeeViewQuantity;
    public void initialize() {
        coffeeViewSize.setDisable(false);
        coffeeViewSize.getItems().removeAll(coffeeViewSize.getItems());
        coffeeViewSize.getItems().addAll("Short", "Tall", "Grande", "Venti");
        coffeeViewSize.getSelectionModel().select("Short");

        coffeeViewQuantity.setDisable(false);
        coffeeViewQuantity.getItems().removeAll(coffeeViewSize.getItems());
        coffeeViewQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        coffeeViewQuantity.getSelectionModel().select(0);
    }




}
