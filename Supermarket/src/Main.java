import store.Store;
import store.StoreUtils;
import store.product.Television;
import store.product.Tshirt;

public class Main {

    public static int DEFAULT_STORE_SIZE = 20;

    public static void main(String[] args) {
        Store myStore = new Store(DEFAULT_STORE_SIZE);
        Tshirt tshirt = new Tshirt("blueTshirt", StoreUtils.SIZE_M, 30.00);
        Television tv = new Television("Samsung", 1100.00, 12, 95);
        myStore.addStock(tv, 50);
        myStore.addStock(tshirt, 20);
        myStore.showProducts();
    }

}
