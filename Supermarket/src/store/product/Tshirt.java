package store.product;

public class Tshirt extends BasicProduct implements SizedProduct {


    private char size;

    public Tshirt(String name, char size, double price){
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @Override
    public char getSize() {
        return size;
    }


    @Override
    public String toString() {
        return "Tshirt{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
