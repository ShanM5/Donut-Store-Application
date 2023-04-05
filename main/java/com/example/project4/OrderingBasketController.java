package com.example.project4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pkg.CoffeeOrder;
import pkg.DonutOrder;
import pkg.Order;

import java.io.IOException;

public class OrderingBasketController {
    Order order = new Order();


    public void addDonutsToOrder(DonutOrder donutOrder){
        order.addDonutOrder(donutOrder);
    }
    public void addCoffeesToOrder(CoffeeOrder CoffeeOrder){
        order.addCoffeeOrder(CoffeeOrder);
    }
}
