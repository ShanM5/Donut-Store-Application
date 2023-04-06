package com.example.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pkg.MenuItem;
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

        orderNumberPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            storeOrderListView.getItems().clear();

            String selectedOrderNumber = String.valueOf(newValue.intValue());

            System.out.println("orderNumber: " + newValue);

            ArrayList<String> viewingOrder = order.getPastOrderStrings(newValue);

            System.out.println("orderNumber: " + newValue + " |||| " + viewingOrder);

            storeOrderListView.setItems(FXCollections.observableArrayList(viewingOrder));

            double tot = order.getPastOrderPrice(newValue);

            System.out.print(tot);

            totalAmount.setText(String.valueOf(tot));


        });




        /* orderNumberPicker.setOnAction(event -> {
            storeOrderListView.getItems().removeAll();
            String selectedOrderNumber = String.valueOf(orderNumberPicker.getValue() - 1);
            System.out.println(selectedOrderNumber);
            // perform action here using the selectedOrderNumber
            ArrayList<Order> temp = order.getPastOrders();
            order = order.getPastOrders().get(Integer.parseInt(selectedOrderNumber));
            System.out.println(order.toString());
            order.printOrder();
            storeOrderListView.setItems(FXCollections.observableArrayList(order.getOrderItemsStrings()));
            totalAmount.setText(order.getOrderPrice()+"");
        });*/


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
        if(orderNumberPicker.getValue() != null) {
            int selectedForRemove = orderNumberPicker.getSelectionModel().getSelectedItem();
            order.removePastOrder(selectedForRemove);
            ObservableList<Integer> items = orderNumberPicker.getItems();
            int itemToRemove = items.indexOf(selectedForRemove);
            items.remove(itemToRemove);
            orderNumberPicker.setValue(null);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Order Number Not Selected!");
            alert.setContentText("Need to select an item in a basket inorder to perform removal");
            alert.show();
        }

    }

    @FXML
    public void exportOrders(){
        int numberOfOrder = order.getPastOrders().size();
        for(int i = 0; i < numberOfOrder; i++){
            order.exportOrder(i);
        }

    }



}
