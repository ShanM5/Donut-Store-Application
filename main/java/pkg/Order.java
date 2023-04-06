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
    ^^^^ MIGHT NOT MATTER ANYMORE, CONSIDER BELOW METHOD INSTEAD
     */


    /*
    use listView<String> as an index cause the listview is direcly correlated to the arraylist of data
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


    public void addCoffee(Coffee coffee){
        System.out.println(orderItems);

        orderItems.add(coffee);

        System.out.println("Num of items in order: " + orderItems.size());
        printOrder();
    }


    public void addDonutOrder(DonutOrder order){

        System.out.println(orderItems);
        orderItems.addAll(order.getDonutList());
        System.out.println("Num of items in order: "+orderItems.size());
        printOrder();
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


    public void printOrder(){
        System.out.println("--------------------------");
        for(MenuItem mi : orderItems){
            System.out.println(mi.toString());
        }
        System.out.println("--------------------------");
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