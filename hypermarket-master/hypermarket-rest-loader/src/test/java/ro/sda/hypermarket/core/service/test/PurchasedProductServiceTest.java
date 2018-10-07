package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Purchase;
import ro.sda.hypermarket.core.entity.PurchasedProduct;
import ro.sda.hypermarket.core.service.ProductService;
import ro.sda.hypermarket.core.service.PurchaseService;
import ro.sda.hypermarket.core.service.PurchasedProductService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class PurchasedProductServiceTest {

    @Autowired
    private PurchasedProductService purchasedProductService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    @Test
    public void testCreate(){
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        Product product = productService.getProduct(10);
        purchasedProduct.setProduct(product);
        purchasedProduct.setProductAmount(1);
        Purchase purchase = purchaseService.getPurchase(10);
        purchasedProduct.setPurchase(purchase);
        purchasedProduct = purchasedProductService.create(purchasedProduct);
        assertNotNull(purchasedProduct);
        System.out.println(purchasedProduct.toString());
        purchasedProductService.delete(purchasedProduct);
    }

    @Test
    public void testUpdate(){
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        Product product = productService.getProduct(8);
        purchasedProduct.setProduct(product);
        purchasedProduct.setProductAmount(3);
        Purchase purchase = purchaseService.getPurchase(7);
        purchasedProduct.setPurchase(purchase);
        purchasedProduct = purchasedProductService.create(purchasedProduct);
        System.out.println(purchasedProduct.toString());
        purchasedProduct.setProductAmount(89);
        purchasedProduct = purchasedProductService.update(purchasedProduct);
        assertTrue(purchasedProduct.getProductAmount() == 89);
        System.out.println(purchasedProduct.toString());
        purchasedProductService.delete(purchasedProduct);
    }

    @Test
    public void testGetPurchasedProduct(){
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        Product product = productService.getProduct(8);
        purchasedProduct.setProduct(product);
        purchasedProduct.setProductAmount(4);
        Purchase purchase = purchaseService.getPurchase(7);
        purchasedProduct.setPurchase(purchase);
        purchasedProduct = purchasedProductService.create(purchasedProduct);
        System.out.println(purchasedProduct.toString());
        assertNotNull(purchasedProductService.getPurchasedProduct(purchasedProduct.getId()));
        purchasedProductService.delete(purchasedProduct);
    }

    @Test
    public void testDelete(){
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        Product product = productService.getProduct(8);
        purchasedProduct.setProduct(product);
        purchasedProduct.setProductAmount(99);
        Purchase purchase = purchaseService.getPurchase(7);
        purchasedProduct.setPurchase(purchase);
        purchasedProduct = purchasedProductService.create(purchasedProduct);
        purchasedProductService.delete(purchasedProduct);
        assertNull(purchasedProductService.getPurchasedProduct(purchasedProduct.getId()));
    }

    @Test
    public void testFindAll(){
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        Product product = productService.getProduct(8);
        purchasedProduct.setProduct(product);
        purchasedProduct.setProductAmount(99);
        Purchase purchase = purchaseService.getPurchase(7);
        purchasedProduct.setPurchase(purchase);
        purchasedProduct = purchasedProductService.create(purchasedProduct);

        PurchasedProduct purchasedProduct1 = new PurchasedProduct();
        purchasedProduct1.setProduct(product);
        purchasedProduct1.setProductAmount(23);
        purchasedProduct1.setPurchase(purchase);
        purchasedProduct1 = purchasedProductService.create(purchasedProduct1);

        List<PurchasedProduct> purchasedProductList = purchasedProductService.findAll();
        assertNotNull(purchasedProductList);
        purchasedProductList.forEach(System.out::println);
        purchasedProductService.delete(purchasedProduct);
        purchasedProductService.delete(purchasedProduct1);
    }
}
