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

/**
 * Controller for the main view menu
 * @author Hieu Nguyen, Shan Malik
 */
public class MainViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;

    Order order = new Order();
    FXMLLoader loader;
    private Parent rootForB;

    OrderingBasketController orderingBasketController;
    StoreOrdersController storeOrdersController;


    /**
     * adds a coffee to the order
     * @param coffee the coffee to be added to the order
     */
    public void addCoffee(Coffee coffee){
        Coffee newCoffee = new Coffee(coffee);
        order.addCoffee(newCoffee);
    }

    /**
     * adds a donut order to donut
     * @param donuts the donut order to be added to the order
     */
    public void addDonut(DonutOrder donuts){
        order.addDonutOrder(donuts);
    }

    public Order getOrderForBasket() throws IOException{
        return null;

    }

    /**
     * returns the order
     * @return returns the order
     */
    public Order getOrder(){
        return order;
    }


    public void resetBasket(){

    }

    /**
     * opens the donut menu from main menu
     * @throws IOException throws error if file is not found
     */
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

    /**
     * opens the coffee menu from main menu
     * @throws IOException throws error if file is not found
     */
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

    /**
     * opens the ordering basket menu from main menu
     * @throws IOException throws error if file is not found
     */
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
        orderingBasketController.setBasket();

    }

    /**
     * opens the store orders from main menu
     * @throws IOException throws error if file is not found
     */
    @FXML
    protected void openStoreOrdersMenu() throws IOException {
        //opens the store order menu
        FXMLLoader loaderStoreOrdersMenu = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent r = loaderStoreOrdersMenu.load();
        StoreOrdersController storeOrdersController =loaderStoreOrdersMenu.getController();
        storeOrdersController.setMainController(this);
        Stage storeOrderMenu = new Stage();
        storeOrderMenu.setScene(new Scene(r));
        storeOrderMenu.show();
        storeOrdersController.setOrderNumbers();
    }

}