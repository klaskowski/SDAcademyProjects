import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<Product>();
    }

    public void emptyCart() {
        products.clear();
    }

    public void addProduct(Product product) throws ProductAlreadyExistsException{
        if(products.contains(product)){
            throw new ProductAlreadyExistsException();
        }
        products.add(product);
    }

    public int getItemCount() {
        return products.size();
    }

    public double getBalance() {
        double balance = 0.0;
        for (Product item : products) {
            balance += item.getValue();
        }
        return balance;
    }

    public void removeItem(Product product)throws ProductNotFoundException{
        if(!products.contains(product)) {
            throw new ProductNotFoundException("No such product!");
        }
        products.remove(product);
    }

}
