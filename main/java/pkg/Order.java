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
        //orderItemsStrings.add("");
    }


    /**
     * adds a coffee to the order
     * @param coffee the coffee to be added
     */
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

    /**
     * adds a donut order to the order
     * @param order the donut order to be added
     */
    public void addDonutOrder(DonutOrder order){

        //System.out.println(orderItems);
        orderItems.addAll(order.getDonutList());
        orderItemsStrings.addAll(order.getDonutListString());
        //System.out.println("Num of items in order: "+orderItems.size());
        //printOrder();
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
     * removes a past order
     * @param input an int that represents the order number and index within the arraylist
     */
    public void removePastOrder(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        orderNumber.remove(Integer.valueOf(input));
        pastOrders.remove(pastOrderIndex);

    }

    public ArrayList<MenuItem> getPastOrderItems(int input){
        int pastOrderIndex = orderNumber.indexOf(Integer.valueOf(input));
        return pastOrders.get(pastOrderIndex);
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

    public ArrayList<ArrayList<String>> getAllPastOrderString(){
        return pastOrdersString;
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

    public int getPastOrderNumber(int index){
        return orderNumber.get(index);

    }




    public ArrayList<Integer> getOrderNumber(){
        return orderNumber;
    }

    /**
     * returns the arraylist of menu items within the order
     * @return returns the arraylist of menu items within the order
     */
    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }





    /**
     * returns the current order's items as an arraylist of strings
     * @return returns the current order's items as an arraylist of strings
     */
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

    /**
     * checks if a string represents a coffee
     * @param item a string to be checked
     * @return returns true if the string represents a coffee, false otherwise
     */
    public boolean isCoffee(String item){
        return (item.contains("Coffee"));
    }

    /**
     * deletes an item from the order given an index
     * @param index the index of the item in the order to be deleted
     */
    public void deleteItem(int index){

        orderItemsStrings.remove(index);
        orderItems.remove(index);

    }

    /**
     * Creates a txt file of all past orders
     * @param orderIndex
     */
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
        ArrayList<String> exportData = pastOrdersString.get(orderIndex);
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