package com.example.project4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderingDonutsController {

    @FXML
    private ComboBox<String> chooseDonut;
    @FXML
    private void initialize() {
        chooseDonut.getItems().addAll("Yeast Donuts", "Cake Donuts", "Donut Holes");
    }


}
