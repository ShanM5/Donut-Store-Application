package pkg;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> orderItems;

    public Order(){
        orderNumber = 1;
        orderItems = new ArrayList<MenuItem>();
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


    public void incrementOrderNumber(){
        orderNumber++;
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
        orderItems.remove(removeDonut);
    }

    public double getOrderPrice(){
        double totalPrice = 0;
        for(MenuItem i : orderItems){
            totalPrice += i.itemPrice();
        }
        return totalPrice;
    }


}
