package pkg;

import java.util.ArrayList;

public class CoffeeOrder {
    private ArrayList<Coffee> coffeeOrder;
    private double orderPrice;

    public CoffeeOrder(){
        coffeeOrder = new ArrayList<Coffee>();
        orderPrice = 0;
    }

    public void addCoffee(Coffee newCoffee){
        coffeeOrder.add(newCoffee);
        orderPrice += newCoffee.itemPrice();
    }
    public void removeCoffee(Coffee removeCoffee){
        try {
            coffeeOrder.remove(removeCoffee);
            orderPrice -= removeCoffee.itemPrice();
        }catch(Exception E){
            return;
        }
    }

    public double getOrderPrice(){
        return orderPrice;
    }
    public ArrayList<Coffee> getCoffeeList(){
        return coffeeOrder;
    }

}