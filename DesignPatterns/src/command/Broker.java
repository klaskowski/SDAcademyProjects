package command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orders;

    public void takeOrder(Order order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
    }

    public void placeOrders() {
        if (orders == null) {
            throw new IllegalArgumentException("orders doesn't exist");
        }
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}
