package pkg;


/**
 * A class representing object donut
 * @author Hieu Nguyen, Shan Malik
 */
public class Donut extends MenuItem{
    private int numberOfDonuts;
    private String donutType;
    private String donutFlavor;
    private double yeastPrice = 1.59;
    private double cakePrice = 1.79;
    private double holePrice = 0.39;

    /**
     * parameter constructor for donut
     * @param type the type of donut
     * @param flavor the flavor of donut
     * @param num the number of donuts
     */
    public Donut(String type, String flavor, int num){
        donutType = type;
        donutFlavor = flavor;
        numberOfDonuts = num;
    }

    /**
     * a parameter constructor that only takes a flavor
     * @param flavor the flavor of the donut
     */
    public Donut(String flavor){
        donutType = null;
        donutFlavor = flavor;
        numberOfDonuts = -1;
    }

    /**
     * calculates donut price based on the type and number
     * @return return double representing the price of donut(s)
     */
    @Override
    public double itemPrice(){
        double typePrice = 0;
        if(donutType.equals("Yeast Donuts")) typePrice = yeastPrice;
        if(donutType.equals("Cake Donuts")) typePrice = cakePrice;
        if(donutType.equals("Donut Holes")) typePrice = holePrice;
        return typePrice * numberOfDonuts;
    }




    /**
     * returns the type of donut
     * @return returns a string donut type
     */
    public String getDonutType(){
        return donutType;
    }

    /**
     * returns the donut flavor
     * @return returns a string donut flavor
     */
    public String getDonutFlavor(){
        return donutFlavor;
    }

    /**
     * returns the int of number of donuts
     * @return an int number of donuts
     */
    public int getNumberOfDonuts(){return numberOfDonuts;}

    /**
     * checks if another donut has the same flavor
     * @param d the donut to check to
     * @return returns true if the donut(s) have the same flavor, false otherwise
     */
    public boolean flavorEquals(Donut d){
        return (this.getDonutFlavor().equals(d.getDonutFlavor()));
    }

    /**
     * returns a string representing the donut
     * @return a string representing the donut
     */
    public String toString(){return donutType + " " + donutFlavor + " " + numberOfDonuts;}

}
