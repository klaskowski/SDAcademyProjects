package store;

import store.product.Product;
import store.stock.Stock;

public class Store {

    int nrOfProducts = 0;
    Stock[] items;

    public Store(int capacity) {
        items = new Stock[capacity];
    }

    public void addStock(Product product, int nrOfItems){
        Stock stock = new Stock(product, nrOfItems);
        items[nrOfProducts] = stock;
        nrOfProducts++;
    }

    public void showProducts(){
        for (int i = 0; i < nrOfProducts; i++){
            System.out.println(items[i].getProduct());
        }
        System.out.println();
    }
}
