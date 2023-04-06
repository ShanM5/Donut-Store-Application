package pkg;

import javafx.scene.control.Menu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private int runningOrderNumber;
    private ArrayList<Integer> orderNumber;
    private ArrayList<MenuItem> orderItems;
    private ArrayList<Order> pastOrders;
    private ArrayList<String> orderItemsStrings;

    public Order(){
        runningOrderNumber = 0;
        orderNumber = new ArrayList<Integer>();
        orderItems = new ArrayList<MenuItem>();
        pastOrders = new ArrayList<Order>();
        orderItemsStrings = new ArrayList<String>();
        orderItemsStrings.add("");
    }


    public void addCoffee(Coffee coffee){
        //System.out.println(orderItems);
        //System.out.println("PRE ADD-------------");
        //printOrder();
        orderItems.add(coffee);
        orderItemsStrings.add(coffee.toString());
        //orderItemsStrings.addAll(coffee);

        //System.out.println("Num of items in order: " + orderItems.size());
        //System.out.println("POST ADD-------------");

    }


    public void addDonutOrder(DonutOrder order){

        //System.out.println(orderItems);
        orderItems.addAll(order.getDonutList());
        orderItemsStrings.addAll(order.getDonutListString());
        //System.out.println("Num of items in order: "+orderItems.size());
        //printOrder();
    }

    public void newOrder(){
        orderNumber.add(runningOrderNumber);
        runningOrderNumber++;
        pastOrders.add(this);
        orderItems.clear();
    }
    public void removePastOrder(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        orderNumber.remove(Integer.valueOf(input));
        pastOrders.remove(pastOrderIndex);

    }

    public ArrayList<MenuItem> getPastOrderItems(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        return pastOrders.get(pastOrderIndex).getOrderItems();
    }
    public double getPastOrderPrice(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        return pastOrders.get(pastOrderIndex).getOrderPrice();
    }


    public ArrayList<Integer> getOrderNumber(){
        return orderNumber;
    }
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }


    public void printOrder(){
        for(MenuItem mi : orderItems){
            System.out.println(mi.toString());
        }
    }

    public ArrayList<String> getOrderItemsStrings(){
        return orderItemsStrings;
    }

    public void removeCoffee(Coffee removeCoffee){
        int coffeeIndex = orderItems.indexOf(removeCoffee);
        orderItems.remove(removeCoffee);
        orderItemsStrings.remove(coffeeIndex);
    }

    public void removeDonut(Donut removeDonut){
        int donutIndex = orderItems.indexOf(removeDonut);
        orderItems.remove(removeDonut);
        orderItemsStrings.remove(donutIndex);

    }

    public double getOrderPrice(){
        double totalPrice = 0;
        for(MenuItem i : orderItems){
            totalPrice += i.itemPrice();
        }
        return totalPrice;
    }

    public int findItem(String item){
        if(isCoffee(item)){

        }
        int ret = 0;
        for(String check : orderItemsStrings){
            if(check.equals(item)) break;
            ret++;
        }
        return ret;
    }

    public boolean isCoffee(String item){
        return (item.contains("Coffee"));
    }

    public void deleteItem(int index){

        orderItemsStrings.remove(index);
        orderItems.remove(index);

    }

    public void exportOrder(int orderIndex){

        String directory = "/com/example/project4/exportOrders";

        Path path = Paths.get(directory);
        if(!Files.exists(path)){
            try{
                Files.createDirectories(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        String fileName = directory + "/Order " + orderIndex + ".txt";
        ArrayList<String> exportData = pastOrders.get(orderIndex).getOrderItemsStrings();
        File ret = new File(fileName);

        try{
            FileWriter fw = new FileWriter(ret);
            BufferedWriter bw = new BufferedWriter(fw);

            for(String s : exportData){
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();

        }catch(IOException e){
            e.printStackTrace();

        }

    }




}