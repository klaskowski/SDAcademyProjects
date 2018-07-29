package builder;

public class Main {
    public static void main(String[] args) throws EmptyListException {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal1 = mealBuilder.prepareNonVegMeal();
        meal1.showItems();
        System.out.println("Total cost:" + meal1.getCost());
        System.out.println();
        Meal meal2 = mealBuilder.prepareNonVegMeal();
        meal2.showItems();
        System.out.println("Total cost: " + meal2.getCost());

        Meal meal3 = new Meal();
        meal3.showItems();
    }
}
