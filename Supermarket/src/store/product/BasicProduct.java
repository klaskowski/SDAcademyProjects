package store.product;

public abstract class BasicProduct {

    String name;
    double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BasicProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
