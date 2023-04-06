package com.example.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pkg.CoffeeOrder;
import pkg.DonutOrder;
import javafx.animation.Timeline;

import pkg.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderingBasketController {
    Order order;
    MainViewController mainViewController;
    FXMLLoader loader;
    Parent root;


    @FXML
    private ListView<String> orderBasketView;

    @FXML
    private TextField subTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField totalAmount;

    private ArrayList<String> listViewString;

    @FXML
    public void initialize() throws IOException {
        //DEFAULT VALUES SET THE SUBTOTAL, SALES TAX and TOTAL AMOUNT TO ZERO
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        totalAmount.setText("$0.00");
        loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();
        mainViewController = loader.getController();

        order = mainViewController.getOrder();


      //  loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
      //  root = loader.load();
      //  mainViewController = loader.getController();
        listViewString = order.getOrderItemsStrings();
        order.printOrder();
        orderBasketView.setItems(FXCollections.observableArrayList(listViewString));
        listViewString = new ArrayList<String>();

        //if (orderBasketView.getItems().get(0).isEmpty()) {
       //     orderBasketView.getSelectionModel().select(1);
       // }
        orderBasketView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 0 && orderBasketView.getItems().get(0).isEmpty()) {
                orderBasketView.getSelectionModel().select(1);
            }
        });

    }

    public void setMainController(MainViewController mainView){
        mainViewController = mainView;
    }

    @FXML
    public void placeOrder(){



        order.newOrder();
        orderBasketView.getItems().clear();
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        totalAmount.setText("$0.00");



        /******************************hello how ur*/
        //CREATE A METHOD TO RESET THE BASEKT, THE PRICE, THE TAX, THE TOTAL WHEN FRESH WHEN WE PLACE THE ORDER and order
        //mainViewController.resetBasket()
    }


    private int findItem(String item){
        int ret = 0;
        for(String ind : orderBasketView.getItems()){
            if(ind.equals(item))break;
            ret++;
        }
        if(ret == 1){
            return ret-1;
        }
        return ret;
    }


    @FXML
    public void removeSelectedItem(){
        Object selectedItem = orderBasketView.getSelectionModel().getSelectedItem();
        orderBasketView.getItems().remove(selectedItem);
        //Use the order's .deleteItem, with string parameter of the list view
        if(orderBasketView.getSelectionModel().getSelectedItem() != null && orderBasketView.getItems().size() != 0) {

            String removed = orderBasketView.getSelectionModel().getSelectedItem().toString();

            System.out.println(removed + "|||| " + findItem(removed));

            int removeIndex = findItem(removed);

            System.out.println("-----------");
            order.deleteItem((removeIndex));
            order.printOrder();
            DecimalFormat numFormat = new DecimalFormat("0.00");

            double subtotal = Double.parseDouble(numFormat.format(order.getOrderPrice()));

            subTotal.setText(subtotal+"");

            double tax = Double.parseDouble(numFormat.format(order.getOrderPrice() * 0.06625));

            salesTax.setText(tax+"");

            double total = Double.parseDouble(numFormat.format(subtotal + tax));

            totalAmount.setText(total+"");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Item not selected!");
            alert.setContentText("Need to select an item in a basket inorder to perform removal");
            alert.show();
        }
    }

    //public OrderingBasketController(Order order){
    //    this.order = order;
   // }

    public void setBasket(){


        order = mainViewController.getOrder();
        listViewString = order.getOrderItemsStrings();
        System.out.println("------ORDERD LIST TO PUT IN ORDERBASKET VIEW" + order.getOrderItems().size());
        order.printOrder();
        listViewString.toString();

        orderBasketView.setItems(FXCollections.observableArrayList(listViewString));

        DecimalFormat numFormat = new DecimalFormat("0.00");

        double subtotal = Double.parseDouble(numFormat.format(order.getOrderPrice()));

        subTotal.setText(subtotal+"");

        double tax = Double.parseDouble(numFormat.format(order.getOrderPrice() * 0.06625));

        salesTax.setText(tax+"");

        double total = Double.parseDouble(numFormat.format(subtotal + tax));

        totalAmount.setText(total+"");

        //salesTax.setText(order.getOrderPrice() );
        System.out.println("------ORDERD LIST TO PUT IN ORDERBASKET VIEW");

    }

    //NEW ORDER USE TO PLACE ORDERS

}