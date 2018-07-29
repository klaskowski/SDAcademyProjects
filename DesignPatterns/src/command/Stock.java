package command;

public class Stock {
    private String name = "abc";
    private int quantity = 100;

    public void buy(){
        System.out.println("Buying " + name + ": " + quantity + " pcs");
    }

    public void sell(){
        System.out.println("Selling " + name + ": " + quantity + " pcs");
    }
}
