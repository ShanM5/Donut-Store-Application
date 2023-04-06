package pkg;

public class Donut extends MenuItem{
    private int numberOfDonuts;
    private String donutType;
    private String donutFlavor;
    private double yeastPrice = 1.59;
    private double cakePrice = 1.79;
    private double holePrice = 0.39;

    public Donut(String type, String flavor, int num){
        donutType = type;
        donutFlavor = flavor;
        numberOfDonuts = num;
    }
    public Donut(String flavor){
        donutType = null;
        donutFlavor = flavor;
        numberOfDonuts = -1;
    }

    @Override
    public double itemPrice(){
        double typePrice = 0;
        if(donutType.equals("Yeast Donuts")) typePrice = yeastPrice;
        if(donutType.equals("Cake Donuts")) typePrice = cakePrice;
        if(donutType.equals("Donut Holes")) typePrice = holePrice;
        return typePrice * numberOfDonuts;
    }



    public Donut getDonut() {return this;}
    public String getDonutType(){
        return donutType;
    }
    public String getDonutFlavor(){
        return donutFlavor;
    }
    public int getNumberOfDonuts(){return numberOfDonuts;}
    public boolean flavorEquals(Donut d){
        return (this.getDonutFlavor().equals(d.getDonutFlavor()));
    }
    public String toString(){return donutType + " " + donutFlavor + " " + numberOfDonuts;}

}
