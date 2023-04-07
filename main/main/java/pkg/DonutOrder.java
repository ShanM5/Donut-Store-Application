package pkg;

import java.util.ArrayList;

/**
 * A class that creates an arrayList of donuts and organizes the donuts
 * @author Hieu Nguyen, Shan Malik
 */
public class DonutOrder {
    private ArrayList<Donut> donutOrder;
    private double orderPrice;

    /**
     * default donut order constructor
     */
    public DonutOrder(){
        donutOrder = new ArrayList<Donut>();
        orderPrice = 0;
    }

    /**
     * adds a donut to the arraylist, and increases the price accordingly
     * @param newDonut the donut to be added to the arraylist
     */
    public void addDonut(Donut newDonut){
        donutOrder.add(newDonut);
        orderPrice += newDonut.itemPrice();
    }

    /**
     * removes a specified donut from the array list and decreases the price accordingly
     * @param removeDonut the donut to be removed
     */
    public void removeDonut(Donut removeDonut){
        for(Donut d : donutOrder){
            if(d.flavorEquals(removeDonut)){

                orderPrice -= d.itemPrice();
                donutOrder.remove(d);
                return;
            }
        }
    }

    /**
     * returns a type of donut given another donut
     * @param checkDonut a donut to reference to
     * @return a specified type of donut
     */
    public String getDonutType(Donut checkDonut){
        Donut type = null;
        for(Donut d : donutOrder){
            if(d.flavorEquals(checkDonut)){
                type = d;
            }
        }
        return type.getDonutType();
    }


    /**
     * gets the price of the arraylist of donuts
     * @return returns a double that is the price of the donuts
     */
    public double getOrderPrice(){
        return Math.abs(orderPrice);
    }


    /**
     * returns the arraylist of donuts
     * @return the arraylist of donuts
     */
    public ArrayList<Donut> getDonutList(){
        return donutOrder;
    }

    /**
     * returns an arraylist of strings of each donut
     * @return returns an arraylist of strings of each donut
     */
    public ArrayList<String> getDonutListString(){
        ArrayList<String> retList = new ArrayList<String>();
        for(Donut d : donutOrder){
            retList.add(d.getDonutFlavor() + "(" + d.getNumberOfDonuts() + ")");
        }
        return retList;
    }

}
