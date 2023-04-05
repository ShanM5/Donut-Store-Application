package pkg;

import javafx.scene.control.Menu;

import java.util.ArrayList;

public class Order {


    /*HLEOOO*?*/

    /*
    You gotta split a string input for remove coffee
    this is because the only data given to see what the user selects is a string describing the coffee
    its formatted like: Coffee(1) Tall [mocha, vanilla]
    You gotta find the coffee based off this info and remove from orderItems
    You gotta be careful cause there can be multiple talls with different amounts and addins, etc.
     */

    //SPLIT STRING INPUT FOR COFFEE******************* SO WE CAN PERFROM REMOVE**S**SD*SD*S*D*SD*SDASBDBASDBADBJWLKHDBAWJHKDBAJDBL
    private int orderNumber;
    private ArrayList<MenuItem> orderItems;

    private ArrayList<ArrayList<MenuItem>> pastOrders;

    public Order(){
        orderNumber = 1;
        orderItems = new ArrayList<MenuItem>();
        pastOrders = new ArrayList<ArrayList<MenuItem>>();
    }

    public void addToOrder(ArrayList<MenuItem> newItems){
        orderItems.addAll(newItems);
    }

    public void addCoffeeOrder(CoffeeOrder order){
        orderItems.addAll(order.getCoffeeList());
    }


    public void addDonutOrder(DonutOrder order){
        orderItems.addAll(order.getDonutList());
    }

    public void newOrder(){
        orderNumber++;
        pastOrders.add(orderItems);
        orderItems.clear();
    }

    public int getOrderNumber(){
        return orderNumber;
    }
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }



    public void removeCoffee(Coffee removeCoffee){
        orderItems.remove(removeCoffee);
    }

    public void removeDonut(Donut removeDonut){
        for(MenuItem d : orderItems){
            if(! (d instanceof Donut)) continue;
            Donut tempDonut = (Donut) d;
            if(tempDonut.flavorEquals(removeDonut)){
                orderItems.remove(tempDonut);
                return;
            }
        }
    }

    public double getOrderPrice(){
        double totalPrice = 0;
        for(MenuItem i : orderItems){
            totalPrice += i.itemPrice();
        }
        return totalPrice;
    }


}
