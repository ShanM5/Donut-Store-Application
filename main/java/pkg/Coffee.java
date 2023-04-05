package pkg;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Coffee extends MenuItem {
    private String cupSize;
    private int cupSizeNum;
    private ArrayList<String> listOfAddins;
    private int numAdds;
    private double addInPrice = 0.3;
    private double sizePriceIncrease = 0.4;
    private double shortPrice = 1.89;


    public Coffee(String size, ArrayList adds){
        cupSize = size;
        listOfAddins = adds;
        numAdds = listOfAddins.size();
        setCupSizeNum(size);

    }

    private void setCupSizeNum(String size){
        switch(size){
            case "Short": cupSizeNum = 0;
            case "Tall": cupSizeNum = 1;
            case "Grande": cupSizeNum = 2;
            case "Venti": cupSizeNum = 3;
            default: cupSizeNum = -1;
        }
    }

    @Override
    public double itemPrice() {

        return shortPrice + (sizePriceIncrease * cupSizeNum) + (addInPrice * numAdds);
    }

    public ArrayList getAddins(){
        return listOfAddins;
    }

    public String getCupSize(){
        return cupSize;
    }



}
