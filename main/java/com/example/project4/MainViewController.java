package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pkg.*;
import java.io.IOException;

/**
 * Controller for the main view menu
 * @author Hieu Nguyen, Shan Malik
 */
public class MainViewController {
    Order order = new Order();



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

    /**
     * returns the order
     * @return returns the order
     */
    public Order getOrder(){
        return order;
    }




    /**
     * opens the donut menu from main menu
     * @throws IOException throws error if file is not found
     */
    @FXML
    protected void openDonutMenu() throws IOException {
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