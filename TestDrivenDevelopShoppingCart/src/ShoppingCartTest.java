import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShoppingCartTest {
    ShoppingCart shoppingCart;

    @Test
    public void testShoppingCartInit() {
        shoppingCart = new ShoppingCart();
        int numberOfItems = shoppingCart.getItemCount();
        Assert.assertEquals(0, numberOfItems);
    }

    @Test
    public void testAddItem() throws ProductAlreadyExistsException {
        shoppingCart = new ShoppingCart();
        Product product1 = new Product("TV", 1000.00);
        shoppingCart.addProduct(product1);
        Assert.assertEquals(1, shoppingCart.getItemCount());

        Product product2 = new Product("TV", 2000.00);
        shoppingCart.addProduct(product2);
        Product product3 = new Product("Speakers", 800.00);
        shoppingCart.addProduct(product3);
        Assert.assertEquals(3, shoppingCart.getItemCount());
    }

    @Test
    public void testEmptyCart() throws ProductAlreadyExistsException {
        shoppingCart = new ShoppingCart();
        Product product1 = new Product("TV", 1000.00);
        shoppingCart.addProduct(product1);
        Assert.assertEquals(1, shoppingCart.getItemCount());
        shoppingCart.emptyCart();
        Assert.assertEquals(0, shoppingCart.getItemCount());
    }

    @Test
    public void testIncreaseBalance() throws ProductAlreadyExistsException {
        shoppingCart = new ShoppingCart();
        Assert.assertEquals(0, Double.compare(0.0, shoppingCart.getBalance()));
        Product product1 = new Product("TV", 1000.00);
        shoppingCart.addProduct(product1);
        Assert.assertEquals(0, Double.compare(1000, shoppingCart.getBalance()));
    }

    @Test
    public void testRemoveItems() throws ProductNotFoundException, ProductAlreadyExistsException {
        shoppingCart = new ShoppingCart();
        Product product1 = new Product("TV", 1000.00);
        shoppingCart.addProduct(product1);
        Product product2 = new Product("TV", 2000.00);
        shoppingCart.addProduct(product2);
        Product product3 = new Product("Speakers", 800.00);
        shoppingCart.addProduct(product3);
        Assert.assertEquals(3, shoppingCart.getItemCount());
        Assert.assertEquals(0, Double.compare(3800, shoppingCart.getBalance()));

        shoppingCart.removeItem(product1);
        Assert.assertEquals(2, shoppingCart.getItemCount());
        Assert.assertEquals(0, Double.compare(2800, shoppingCart.getBalance()));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRemoveException() throws ProductNotFoundException, ProductAlreadyExistsException {
        shoppingCart = new ShoppingCart();
        expectedException.expect(ProductNotFoundException.class);
        expectedException.expectMessage("No such product!");

        Product product1 = new Product("TV", 1000.00);
        shoppingCart.addProduct(product1);
        Product product2 = new Product("TV", 2000.00);
        shoppingCart.addProduct(product2);
        Product product3 = new Product("Speakers", 800.00);
        shoppingCart.removeItem(product3);


    }

}
