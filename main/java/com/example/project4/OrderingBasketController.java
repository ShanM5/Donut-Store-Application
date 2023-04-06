package com.example.project4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pkg.CoffeeOrder;
import pkg.DonutOrder;
import pkg.*;

import java.io.IOException;

public class OrderingBasketController {
    Order order = new Order();
    MainViewController mainViewController;


    @FXML
    private ListView<String> orderBasketView;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField totalAmount;

    @FXML
    public void initialize(){
        //DEFAULT VALUES SET THE SUBTOTAL, SALES TAX and TOTAL AMOUNT TO ZERO
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        totalAmount.setText("$0.00");
    }

    public void setMainController(MainViewController mainView){
        mainViewController = mainView;
    }

   // @FX
}