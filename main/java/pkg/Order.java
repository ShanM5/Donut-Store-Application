package pkg;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A class that has an ararylist of menuitems that represents an order
 * @author Hieu Nguyen, Shan Malik
 */
public class Order {

    private int runningOrderNumber;
    private ArrayList<Integer> orderNumber;
    private ArrayList<MenuItem> orderItems;
    private ArrayList<ArrayList<MenuItem>> pastOrders;
    private ArrayList<ArrayList<String>> pastOrdersString;

    private ArrayList<String> orderItemsStrings;

    /**
     * default constructor for order
     */
    public Order(){
        runningOrderNumber = 1;
        orderNumber = new ArrayList<Integer>();
        orderItems = new ArrayList<MenuItem>();
        pastOrders = new ArrayList<ArrayList<MenuItem>>();
        pastOrdersString = new ArrayList<ArrayList<String>>();
        orderItemsStrings = new ArrayList<String>();
    }


    /**
     * adds a coffee to the order
     * @param coffee the coffee to be added
     */
    public void addCoffee(Coffee coffee){
        orderItems.add(coffee);
        orderItemsStrings.add(coffee.toString());
    }

    /**
     * adds a donut order to the order
     * @param order the donut order to be added
     */
    public void addDonutOrder(DonutOrder order){

        orderItems.addAll(order.getDonutList());
        orderItemsStrings.addAll(order.getDonutListString());
    }

    /**
     * logs the current order into PastOrders and resets the current order
     */
    public void newOrder(){
        orderNumber.add(runningOrderNumber);
        runningOrderNumber++;
        ArrayList<MenuItem> miTemp = new ArrayList<>(orderItems);
        pastOrders.add(miTemp);
        ArrayList<String> miStrings = new ArrayList<>(orderItemsStrings);
        pastOrdersString.add(miStrings);
        orderItems.clear();
        orderItemsStrings.clear();
    }

    /**
     * clears the arraylist of current menu items and strings
     */
    public void clearOrder(){
        orderItems.clear();
        orderItemsStrings.clear();
    }

    /**
     * removes a past order
     * @param input an int that represents the order number and index within the arraylist
     */
    public void removePastOrder(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        orderNumber.remove(Integer.valueOf(input));
        pastOrders.remove(pastOrderIndex);

    }


    /**
     * gets an arraylist of a past order's menu items
     * @param input the index/number representation of the past order
     * @return returns an arraylist of strings containing the past order's menu items
     */
    public ArrayList<String> getPastOrderStrings(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        return pastOrdersString.get(pastOrderIndex);
    }

    /**
     * gets the total price of a past order
     * @param input the index/number representation of the past order
     * @return returns a double of the past order's price
     */
    public double getPastOrderPrice(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));

        double totalPrice = 0;
        for(MenuItem i : pastOrders.get(pastOrderIndex)){
            totalPrice += i.itemPrice();
        }
        return totalPrice;
    }

    /**
     * returns the past order number given an index
     * @param index index of the past order number
     * @return returns the number of the order
     */
    public int getPastOrderNumber(int index){
        return orderNumber.get(index);
    }

    /**
     * returns the current order's items as an arraylist of strings
     * @return returns the current order's items as an arraylist of strings
     */
    public ArrayList<String> getOrderItemsStrings(){
        return orderItemsStrings;
    }

    /**
     * returns the 2d arraylist of past orders
     * @return returns the 2d arraylist of past orders
     */
    public ArrayList<ArrayList<MenuItem>> getPastOrders(){
        return pastOrders;
    }

    /**
     * calculates the current order's price
     * @return return a double representing the current order's price
     */
    public double getOrderPrice(){
        double totalPrice = 0;
        for(MenuItem i : orderItems){
            totalPrice += i.itemPrice();
        }
        return totalPrice;
    }

    /**
     * deletes an item from the order given an index
     * @param index the index of the item in the order to be deleted
     */
    public void deleteItem(int index) {

        orderItemsStrings.remove(index);
        orderItems.remove(index);

    }

}