package pkg;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private int numCoffees;
    private String cupSize;
    private int cupSizeNum;
    private ArrayList<String> listOfAddins;
    private int numAdds;
    private double addInPrice = 0.3;
    private double sizePriceIncrease = 0.4;
    private double shortPrice = 1.89;


    public Coffee(){
        listOfAddins = new ArrayList<String>();
        cupSize = "Short";
        cupSizeNum = 0;
        numCoffees = 1;

    }

    public Coffee(String size, ArrayList adds, int num){
        numCoffees = num;
        cupSize = size;
        listOfAddins = adds;
        numAdds = listOfAddins.size();
        setCupSizeNum(size);

    }

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
    public void setCupSizeString(String size){
        cupSize = size;
        setCupSizeNum(cupSize);
    }
    public void setNumCoffees(int num){
        numCoffees = num;
    }

    @Override
    public double itemPrice() {
        return (shortPrice + (sizePriceIncrease * cupSizeNum) + (addInPrice * numAdds)) * numCoffees;
    }



    public void addAddin(String input){
        listOfAddins.add(input);
        numAdds = listOfAddins.size();
    }
    public void removeAddin(String input){
        listOfAddins.remove(input);
        numAdds = listOfAddins.size();
    }


    public ArrayList getAddins(){
        return listOfAddins;
    }
    public int getNumAdds(){
        return numAdds;
    }

    public String getCupSize(){
        return cupSize;
    }

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
