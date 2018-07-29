package builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float totalCost = 0f;
        for(Item item:items){
            totalCost += item.price();
        }
        return totalCost;
    }

    public void showItems() throws EmptyListException {
        if(!items.isEmpty()) {
            for (Item item : items) {
                System.out.println(item.name() + " (" + item.packing().pack() + "): " + item.price());
            }
        } else {
            throw new EmptyListException("The list is empty");
        }
    }
}
