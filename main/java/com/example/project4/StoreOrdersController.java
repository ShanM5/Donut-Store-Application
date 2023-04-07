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

import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * controller for the store orders menu
 * @author Hieu Nguyen, Shan Malik
 */
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
    DecimalFormat numFormat = new DecimalFormat("0.00");
    private ArrayList<Integer> numbersForOrderNumberPicker = new ArrayList<Integer>();
    Order order;

    /**
     * initializes the menu
     * @throws IOException throws error if file is not found
     */
    @FXML
    public void initialize() throws IOException {
        totalAmount.setText("$0.00");

        loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();
        mainViewController = loader.getController();

        orderNumberPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            storeOrderListView.getItems().clear();

            if(newValue != null) {
                ArrayList<String> viewingOrder = order.getPastOrderStrings(newValue);
                storeOrderListView.setItems(FXCollections.observableArrayList(viewingOrder));
                double tot = order.getPastOrderPrice(newValue);
                System.out.print(tot);
                totalAmount.setText(String.valueOf(tot));
            }
        });
    }

    /**
     * sets the order numbers of the list
     */
    public void setOrderNumbers(){
        order = mainViewController.getOrder();
        int numberOfOrders = order.getPastOrders().size();

        for(int i = 1; i < numberOfOrders + 1; i++){
            numbersForOrderNumberPicker.add(i);
        }

        orderNumberPicker.setItems(FXCollections.observableArrayList((ArrayList<Integer>) numbersForOrderNumberPicker));

    }

    /**
     * sets main view controller to a given main view
     * @param mainView the main view to be set to
     */
    public void setMainController(MainViewController mainView){
        mainViewController = mainView;
    }

    /**
     * cancels an order within the list
     */
    @FXML
    public void cancelOrder(){
        if(orderNumberPicker.getValue() != null) {

            int selectedForRemove = orderNumberPicker.getSelectionModel().getSelectedItem();
            order.removePastOrder(selectedForRemove);
            ObservableList<Integer> items = orderNumberPicker.getItems();
            int itemToRemove = items.indexOf(selectedForRemove);
            items.remove(itemToRemove);
            orderNumberPicker.setValue(null);
            totalAmount.setText("$0.00");

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Order Number Not Selected!");
            alert.setContentText("Need to select an item in a basket inorder to perform removal");
            alert.show();
        }

    }

    /**
     * exports orders as a txt file
     */
    @FXML
    public void exportOrders(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("exportedOrders.txt"));
            int i = 0;
            for(ArrayList<MenuItem> pastOrder: order.getPastOrders()){

                String oNum = String.valueOf(order.getPastOrderNumber(i));
                writer.write("Order Number: "+ oNum);
                writer.newLine();

                for(String menuItem : order.getPastOrderStrings(Integer.parseInt(oNum))){
                    writer.write(menuItem);
                    writer.newLine();
                }
                writer.newLine();

                i++;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





}
