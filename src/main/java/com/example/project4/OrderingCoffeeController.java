package com.example.project4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pkg.Coffee;

import java.io.IOException;
import java.text.DecimalFormat;

public class OrderingCoffeeController {

    @FXML private ComboBox coffeeViewSize;
    @FXML private ComboBox coffeeViewQuantity;
    @FXML private CheckBox sweetCream;
    @FXML private CheckBox frenchVanilla;
    @FXML private CheckBox irishCream;
    @FXML private CheckBox caramel;
    @FXML private CheckBox mocha;

    @FXML private TextField coffeePrice;

    Coffee coffee = new Coffee();
    DecimalFormat numFormat = new DecimalFormat("0.00");
    public void initialize() {
        coffeePrice.setText("$1.89");
        coffeeViewSize.setDisable(false);
        coffeeViewSize.getItems().removeAll(coffeeViewSize.getItems());
        coffeeViewSize.getItems().addAll("Short", "Tall", "Grande", "Venti");
        coffeeViewSize.getSelectionModel().select("Short");
        coffeeViewQuantity.setDisable(false);
        coffeeViewQuantity.getItems().removeAll(coffeeViewSize.getItems());
        coffeeViewQuantity.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        coffeeViewQuantity.getSelectionModel().select(0);



        sweetCream.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Sweet Cream");
            } else {
                coffee.removeAddin("Sweet Cream");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });

        frenchVanilla.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("French Vanilla");
            } else {
                coffee.removeAddin("French Vanilla");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });

        mocha.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Mocha");
            } else {
                coffee.removeAddin("Mocha");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });

        irishCream.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Irish Cream");
            } else {
                coffee.removeAddin("Irish Cream");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });

        caramel.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Caramel");
            } else {
                coffee.removeAddin("Caramel");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });




        coffeeViewSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            coffee.setCupSizeString(coffeeViewSize.getSelectionModel().getSelectedItem().toString());
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText(formattedNumber);
        });


        coffeeViewQuantity.valueProperty().addListener((observable, oldValue, newValue) -> {
            coffee.setNumCoffees((Integer) coffeeViewQuantity.getSelectionModel().getSelectedItem());
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText(formattedNumber);
        });







    }

    @FXML public void addToOrder(){
        System.out.println(coffee.toString());
    }






}
