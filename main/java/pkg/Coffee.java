package pkg;

import java.util.ArrayList;


/**
 * A class that creates an object coffee
 * @author  Hieu Nguyen, Shan Malik
 */
public class Coffee extends MenuItem {
    private int numCoffees;
    private String cupSize;
    private int cupSizeNum;
    private ArrayList<String> listOfAddins;
    private int numAdds;
    private double addInPrice = 0.3;
    private double sizePriceIncrease = 0.4;
    private double shortPrice = 1.89;


    /**
     * Default constructor for Coffee
     */
    public Coffee(){
        listOfAddins = new ArrayList<String>();
        cupSize = "Short";
        cupSizeNum = 0;
        numCoffees = 1;

    }

    /**
     * Copy constructor for coffee
     * @param c the coffee to be copied from
     */
    public Coffee(Coffee c){
         this.listOfAddins = c.listOfAddins;
         this.cupSize = c.cupSize;
         this.cupSizeNum = c.cupSizeNum;
         this.numCoffees = c.numCoffees;
         this.numAdds = c.numAdds;

    }

    /**
     * Parameter constructor for coffee
     * @param size the size of the coffee
     * @param adds the list of addins for the coffee
     * @param num the quantity of coffee
     */
    public Coffee(String size, ArrayList adds, int num){
        numCoffees = num;
        cupSize = size;
        listOfAddins = adds;
        numAdds = listOfAddins.size();
        setCupSizeNum(size);

    }

    /**
     * sets the cupsize variable to a known int
     * @param size the string of the cup size
     */
    private void setCupSizeNum(String size){
        switch(size){
            case "Short":
                cupSizeNum = 0;
                break;
            case "Tall":
                cupSizeNum = 1;
                break;
            case "Grande":
                cupSizeNum = 2;
                break;
            case "Venti":
                cupSizeNum = 3;
                break;
            default:
                cupSizeNum = -1;
        }
    }

    /**
     * sets a new cupsize
     * @param size the new size to be updated to
     */
    public void setCupSizeString(String size){
        cupSize = size;
        setCupSizeNum(cupSize);
    }

    /**
     * sets a new quantity of coffee
     * @param num the new number of coffees to update
     */
    public void setNumCoffees(int num){
        numCoffees = num;
    }

    /**
     * returns the price of the coffee based on size, addins, and quantity
     * @return returns a double representing the coffee(s) price
     */
    @Override
    public double itemPrice() {
        return (shortPrice + (sizePriceIncrease * cupSizeNum) + (addInPrice * numAdds)) * numCoffees;
    }


    /**
     * add a new addin to the coffee
     * @param input a string representing the addin
     */
    public void addAddin(String input){
        listOfAddins.add(input);
        numAdds = listOfAddins.size();
    }

    /**
     * removes an addin from
     * @param input
     */
    public void removeAddin(String input){
        listOfAddins.remove(input);
        numAdds = listOfAddins.size();
    }

    /**
     * returns an arraylist of the addins of the coffee
     * @return returs an arraylist of the addins
     */
    public ArrayList getAddins(){
        return listOfAddins;
    }
    public int getNumAdds(){
        return numAdds;
    }

    public String getCupSize(){
        return cupSize;
    }

    /**
     * checks the addins list to another list of addins
     * @param adds a second arraylist of addins to check to
     * @return return true if the addins are the same, false otherwise
     */
    public boolean checkAddins(ArrayList<String> adds){
        if(this.listOfAddins.size() != adds.size()) return false;
        for(String a : this.listOfAddins){
            if(!adds.contains(a)) return false;
        }
        return true;

    }




    public boolean equals(Coffee c){
        return checkAddins(c.getAddins()) && (this.cupSize.equals(c.cupSize)) && (this.numCoffees == c.numCoffees);
    }

    @Override
    public String toString(){
        return ("Coffee(" + numCoffees + ") " + cupSize + listOfAddins);
    }



}
