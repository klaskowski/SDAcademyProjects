package ro.sda.logic;

import ro.sda.model.Options;

import java.util.ArrayList;
import java.util.List;

public class GroceryUtil {
    public static List<String> getAvailableGroceries(Options option){
        List<String> groceryList = new ArrayList<>();

        if(option.equals(Options.TOMATO)){
            groceryList.add("Cherry Tomato");
            groceryList.add("Another kind of tomato");
        } else if(option.equals(Options.CUCUMBER)){
            groceryList.add("Cournishon");
            groceryList.add("Fabio");
        } else if(option.equals(Options.PEPPER)){
            groceryList.add("Hot pepper");
            groceryList.add("Green pepper");
        } else {
            groceryList.add("Nothing available");
        }

        return groceryList;
    }
}
