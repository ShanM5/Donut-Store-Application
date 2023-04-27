package com.example.project4;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pkg.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Controller for the ordering basket menu
 * @author Hieu Nguyem, Shan Malik
 */
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

    DecimalFormat numFormat;

    /**
     * initializes the menu
     *
     * @throws IOException throws error if file is not found
     */
    @FXML
    public void initialize() throws IOException {
        //DEFAULT VALUES SET THE SUBTOTAL, SALES TAX and TOTAL AMOUNT TO ZERO

        numFormat = new DecimalFormat("0.00");
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        totalAmount.setText("$0.00");
        loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();
        mainViewController = loader.getController();

        order = mainViewController.getOrder();

        listViewString = order.getOrderItemsStrings();
        orderBasketView.setItems(FXCollections.observableArrayList(listViewString));
        listViewString = new ArrayList<String>();



    }

    public void setMainController(MainViewController mainView) {
        mainViewController = mainView;
    }

    /**
     * places order and sends order to store orders
     */
    @FXML
    public void placeOrder() {

        if (listViewString.size() != 0) {
            order.newOrder();
            orderBasketView.getItems().clear();
            subTotal.setText("$0.00");
            salesTax.setText("$0.00");
            totalAmount.setText("$0.00");
        }

    }


    /**
     * finds index of item within the order basket given a string
     * @param item the string to be found in the basket
     * @return returns the index of the item in the order
     */
    private int findItem(String item) {
        int ret = 0;
        for (String ind : orderBasketView.getItems()) {
            if (ind.equals(item)) break;
            ret++;
        }
        return ret;
    }


    /**
     * removes a selected item from the basket
     */
    @FXML
    public void removeSelectedItem() {
        Object selectedItem = orderBasketView.getSelectionModel().getSelectedItem();
        double subtotal, tax, total;
        if (orderBasketView.getItems().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Basket is empty!");
            alert.setContentText("Need to add items to basket inorder to perform removal!");
            alert.show();
            return;
        }
        orderBasketView.getItems().remove(selectedItem);
        int selectedIndex = orderBasketView.getSelectionModel().getSelectedIndex();
        if (orderBasketView.getItems().size() == 0) {
            orderBasketView.getItems().clear();
            order.clearOrder();
            subTotal.setText("$0.00");
            salesTax.setText("$0.00");
            totalAmount.setText("$0.00");
        } else if (selectedIndex == 0 && orderBasketView.getItems().size() == 1) {
            order.deleteItem(0);
        } else if (orderBasketView.getSelectionModel().getSelectedItem() != null && orderBasketView.getItems().size() != 1.0) {
            int removeIndex = findItem(orderBasketView.getSelectionModel().getSelectedItem().toString());
            if(removeIndex == 0){
                order.deleteItem((removeIndex));
            }else{
                order.deleteItem((removeIndex)+1);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Item not selected!");
            alert.setContentText("Need to select an item in a basket inorder to perform removal");
            alert.show();
            return;
        }
        subtotal = Double.parseDouble(numFormat.format(order.getOrderPrice()));
        tax = Double.parseDouble(numFormat.format(order.getOrderPrice() * 0.06625));
        total = Double.parseDouble(numFormat.format(subtotal + tax));
        subTotal.setText("$" + subtotal);
        totalAmount.setText("$" + total);
        salesTax.setText("$" + tax);
    }



    /**
     * sets basket view and prices
     */
    public void setBasket(){
        order = mainViewController.getOrder();
        listViewString = order.getOrderItemsStrings();

        listViewString.toString();

        orderBasketView.setItems(FXCollections.observableArrayList(listViewString));

        DecimalFormat numFormat = new DecimalFormat("0.00");

        double subtotal = Double.parseDouble(numFormat.format(order.getOrderPrice()));

        subTotal.setText("$" + subtotal);

        double tax = Double.parseDouble(numFormat.format(order.getOrderPrice() * 0.06625));

        salesTax.setText("$" + tax);

        double total = Double.parseDouble(numFormat.format(subtotal + tax));

        totalAmount.setText("$" + total);


    }

}


