package store.product;

public class Television extends BasicProduct implements ElectricProduct {


    private int warranty;
    private double diag;

    public Television(String name, double price, int warranty, double diag){
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.diag = diag;
    }

    @Override
    public int getWarranty() {
        return 0;
    }


    @Override
    public String toString() {
        return "Television{" +
                "warranty=" + warranty +
                ", diag=" + diag +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
