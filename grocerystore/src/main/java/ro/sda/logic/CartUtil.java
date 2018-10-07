package ro.sda.logic;

import ro.sda.model.Options;

import java.util.ArrayList;
import java.util.List;

public class CartUtil {

    public static List<String> addToCart(String product){
        List<String>  cart = new ArrayList<>();
        cart.add(product);
        return cart;
    }

    public static void displayCart(List<String> cart){
        if(!cart.isEmpty()) {
            for (String s : cart) {
                System.out.println(s);
            }
        } else {
            System.out.println("Cart empty");
        }
    }

}
