package store.product;

public class ElectricTshirt extends BasicProduct implements SizedProduct, ElectricProduct {

    int warranty;
    char size;

    @Override
    public int getWarranty() {
        return warranty;
    }

    @Override
    public char getSize() {
        return size;
    }
}
