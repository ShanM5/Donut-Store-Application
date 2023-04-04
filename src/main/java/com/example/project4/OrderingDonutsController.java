package com.example.project4;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class OrderingDonutsController {

    @FXML
    ComboBox chooseDonut;
    private String donutType = "Yeast Donut";

    @FXML
    public ImageView donutMenuImage;

    Image image;
    @FXML
    public void initialize() {
        chooseDonut.setDisable(false);
        chooseDonut.getItems().removeAll(chooseDonut.getItems());
        chooseDonut.getItems().addAll("Yeast Donuts", "Cake Donuts", "Donut Holes");
        chooseDonut.getSelectionModel().select("Yeast Donuts");
        String selected = (String) chooseDonut.getSelectionModel().getSelectedItem();

        chooseDonut.valueProperty().addListener((observable, oldValue, newValue) -> {
            donutType = (newValue.toString());

            //*****CHANGE THE DONUT IMAGE HERE*****

            if(newValue.toString() == "Donut Holes"){
                Image image = new Image(getClass().getResource("/com/example/project4/donutHole.jpg").toExternalForm());
                //System.out.println("INNN " +newValue.toString());
                donutMenuImage.setImage(image);
            }

        });

        System.out.println(selected);

    }

    @FXML
    public void changeSelectedDonutType(){


    }

}
