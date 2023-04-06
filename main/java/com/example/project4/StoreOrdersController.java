package com.example.project4;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pkg.Order;

import java.io.IOException;
import java.util.ArrayList;

public class StoreOrdersController {

    @FXML
    private ComboBox<Integer> orderNumberPicker;
    @FXML
    private ListView<String> storeOrderListView;
    @FXML
    private TextField totalAmount;


    MainViewController mainViewController;
    FXMLLoader loader;
    Parent root;


    private ArrayList<Integer> numbersForOrderNumberPicker = new ArrayList<Integer>();

    Order order;

    @FXML
    public void initialize() throws IOException {
        totalAmount.setText("$0.00");

        loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();
        mainViewController = loader.getController();

        //order = mainViewController.getOrder();
      //  int numberOfOrders = order.getPastOrders().size();

//        for(int i = 1; i < numberOfOrders + 1; i++){
//            numbersForOrderNumberPicker.add(i);
//        }


     //   orderNumberPicker.setItems(FXCollections.observableArrayList((ArrayList<Integer>) numbersForOrderNumberPicker));



    }


    public void setOrderNumbers(){
        order = mainViewController.getOrder();
        int numberOfOrders = order.getPastOrders().size();

        for(int i = 1; i < numberOfOrders + 1; i++){
            numbersForOrderNumberPicker.add(i);
        }


        orderNumberPicker.setItems(FXCollections.observableArrayList((ArrayList<Integer>) numbersForOrderNumberPicker));


    }

    public void setMainController(MainViewController mainView){
        mainViewController = mainView;
    }

    @FXML
    public void cancelOrder(){

    }

    @FXML
    public void exportOrders(){

    }



}
