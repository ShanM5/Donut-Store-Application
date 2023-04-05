package pkg;

import java.util.ArrayList;

public class DonutOrder {
    private ArrayList<Donut> donutOrder;
    private double orderPrice;

    public DonutOrder(){
        donutOrder = new ArrayList<Donut>();
        orderPrice = 0;
    }

    public void addDonut(Donut newDonut){
        donutOrder.add(newDonut);
        orderPrice += newDonut.itemPrice();
    }
    public void removeDonut(Donut removeDonut){
        try {
            donutOrder.remove(removeDonut);
            orderPrice -= removeDonut.itemPrice();
        }catch(Exception E){
            return;
        }
    }

    public double getOrderPrice(){
        return orderPrice;
    }
    public DonutOrder getDonutOrder(){
        return this;
    }

    public ArrayList<Donut> getDonutList(){
        return donutOrder;
    }
    public ArrayList<String> getDonutListString(){
        ArrayList<String> retList = new ArrayList<String>();
        for(Donut d : donutOrder){
            retList.add(d.getDonutFlavor() + "(" + d.getNumberOfDonuts() + ")");
        }
        return retList;
    }

}
