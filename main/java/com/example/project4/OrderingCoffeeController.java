package com.example.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pkg.*;
import java.util.ArrayList;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * menu controller for coffee menu
 * @author Hieu Nguyen, Shan Malik
 */
public class OrderingCoffeeController {
    @FXML private ComboBox coffeeViewSize;
    @FXML private ComboBox coffeeViewQuantity;
    @FXML private CheckBox sweetCream;
    @FXML private CheckBox frenchVanilla;
    @FXML private CheckBox irishCream;
    @FXML private CheckBox caramel;
    @FXML private CheckBox mocha;
    private Parent root;
    FXMLLoader loader;
    MainViewController mainViewController;
    @FXML private TextField coffeePrice;
    Coffee coffee = new Coffee();
    DecimalFormat numFormat = new DecimalFormat("0.00");

    /**
     * initializes the coffee menu
     * @throws IOException throws error if file is not found
     */
    public void initialize() throws IOException {
        coffeePrice.setText("$1.89");
        coffeeViewSize.setDisable(false);
        coffeeViewSize.getItems().removeAll(coffeeViewSize.getItems());
        coffeeViewSize.getItems().addAll("Short", "Tall", "Grande", "Venti");
        coffeeViewSize.getSelectionModel().select("Short");
        coffeeViewQuantity.setDisable(false);
        coffeeViewQuantity.getItems().removeAll(coffeeViewSize.getItems());
        int maxCoffee = 20;

        ArrayList<Integer> coffeeNum = new ArrayList<Integer>();
        for(int i = 1; i <= maxCoffee; i++) {
            coffeeNum.add(i);
        }

        ObservableList<Integer> numbersForCoffee = FXCollections.observableArrayList(coffeeNum);
        coffeeViewQuantity.getItems().addAll(numbersForCoffee);
        coffeeViewQuantity.getSelectionModel().select(0);
        doSweetCream();
        doFrenchVanilla();
        doMocha();
        doIrishCream();
        doCaramel();
        doCoffeeSize();
        doQuantity();
        loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();
        mainViewController = loader.getController();
    }

    /**
     * Checks selects for sweet cream
     */
    public void doSweetCream(){
        sweetCream.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Sweet Cream");
            } else {
                coffee.removeAddin("Sweet Cream");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });
    }

    /**
     * checks selects for french vanilla
     */
    public void doFrenchVanilla(){
        frenchVanilla.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("French Vanilla");
            } else {
                coffee.removeAddin("French Vanilla");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });
    }

    /**
     * checks selects for mocha
     */
    public void doMocha(){
        mocha.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Mocha");
            } else {
                coffee.removeAddin("Mocha");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });
    }

    /**
     * checks selects for irish cream
     */
    public void doIrishCream(){
        irishCream.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Irish Cream");
            } else {
                coffee.removeAddin("Irish Cream");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });
    }

    /**
     * checks selects for caramel
     */
    public void doCaramel(){
        caramel.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                coffee.addAddin("Caramel");
            } else {
                coffee.removeAddin("Caramel");
            }
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText("$" + formattedNumber);
        });
    }

    /**
     * checks selects for coffee size
     */
    public void doCoffeeSize(){
        coffeeViewSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            coffee.setCupSizeString(coffeeViewSize.getSelectionModel().getSelectedItem().toString());
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText(formattedNumber);
        });
    }

    /**
     * checks selects for quantity
     */
    public void doQuantity(){
        coffeeViewQuantity.valueProperty().addListener((observable, oldValue, newValue) -> {
            coffee.setNumCoffees((Integer) coffeeViewQuantity.getSelectionModel().getSelectedItem());
            String formattedNumber = numFormat.format(coffee.itemPrice());
            coffeePrice.setText(formattedNumber);
        });
    }


    /**
     * adds coffee to the main menu controller
     * @throws IOException throws error if file is not found
     */
    @FXML public void addToOrder() throws IOException {
        Coffee newCoffee = coffee;
        mainViewController.addCoffee(coffee);
    }

    /**
     * sets main controller
     * @param mainView the main view controller to be set to
     */
    public void setMainController(MainViewController mainView){
        mainViewController = mainView;
    }
}