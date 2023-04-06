package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pkg.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    Order order = new Order();


    @FXML
    public void initialize() throws IOException{
        OrderingBasketController orderingBasketController = new OrderingBasketController();
    }

    public void addCoffee(Coffee coffee){

        order.addCoffee(coffee);



    }

    public void addDonut(DonutOrder donuts){
        order.addDonutOrder(donuts);
    }

    public Order getOrderForBasket() throws IOException{
        return null;

    }
    public Order getOrder(){
        return order;
    }

    @FXML
    protected void openDonutMenu() throws IOException {
        //opens the donut menu stage
        FXMLLoader loaderDonutMenu = new FXMLLoader(getClass().getResource("OrderingDonutsView.fxml"));
        Parent r = loaderDonutMenu.load();
        OrderingDonutsController orderingDonutsController = loaderDonutMenu.getController();
        orderingDonutsController.setMainController(this);
        Stage donutMenu = new Stage();
        donutMenu.setScene(new Scene(r));
        donutMenu.show();

    }
    @FXML
    protected void openCoffeeMenu() throws IOException {
        //opens the coffee menu stage
        FXMLLoader loaderCoffeeMenu = new FXMLLoader(getClass().getResource("OrderingCoffeeView.fxml"));
        Parent r = loaderCoffeeMenu.load();
        OrderingCoffeeController orderingCoffeeController = loaderCoffeeMenu.getController();
        orderingCoffeeController.setMainController(this);
        Stage coffeeMenu = new Stage();
        coffeeMenu.setScene(new Scene(r));
        coffeeMenu.show();
    }

    @FXML
    protected void openOrderingBasketMenu() throws IOException {
        //opens the ordering basket menu stage
        FXMLLoader loaderOrderingBasketMenu = new FXMLLoader(getClass().getResource("OrderingBasketView.fxml"));
        Parent r = loaderOrderingBasketMenu.load();
        OrderingBasketController orderingBasketController = loaderOrderingBasketMenu.getController();
        orderingBasketController.setMainController(this);
        Stage basketMenu = new Stage();
        basketMenu.setScene(new Scene(r));
        basketMenu.show();

    }
    @FXML
    protected void openStoreOrdersMenu() throws IOException {
        //opens the store order menu
        FXMLLoader loaderStoreOrdersMenu = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent r = loaderStoreOrdersMenu.load();
        Stage storeOrderMenu = new Stage();
        storeOrderMenu.setScene(new Scene(r));
        storeOrderMenu.show();
    }

}