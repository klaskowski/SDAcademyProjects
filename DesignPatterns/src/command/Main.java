package command;

public class Main {
    public static void main(String[] args) {
        Stock stock1 = new Stock();

        Broker broker = new Broker();
        broker.takeOrder(new BuyStock(stock1));
        broker.takeOrder(new SellStock(stock1));
        broker.placeOrders();
    }
}
