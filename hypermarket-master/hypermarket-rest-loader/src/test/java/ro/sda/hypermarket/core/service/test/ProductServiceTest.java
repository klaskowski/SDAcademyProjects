package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.CategoryService;
import ro.sda.hypermarket.core.service.ProductService;
import ro.sda.hypermarket.core.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testCreate(){
        Product product = new Product();
        product.setName("Electronic Prod 5");
        Category category = new Category();
        category  = categoryService.getCategory(12, false);
        product.setCategory(category);
        product.setCode("1190");
        product.setDescription("Electronic Prod 5 description");
        Supplier supplier = new Supplier();
        supplier = supplierService.getSupplier(1, false);
        product.setSupplier(supplier);

        productService.create(product, false);
        System.out.println(product.toString());
        assertNotNull(product);
        productService.delete(product, false);
    }

    @Test
    public void testUpdate(){
        Product product = new Product();
        product.setName("Test Product2");
        Category category = new Category();
        category  = categoryService.getCategory(12, false);
        product.setCategory(category);
        product.setCode("1234");
        product.setDescription("Description for test product");
        Supplier supplier = new Supplier();
        supplier = supplierService.getSupplier(1, false);
        product.setSupplier(supplier);

        productService.create(product, false);
        System.out.println(product.toString());
        product.setDescription("Updated description for product");
        productService.update(product, false);
        assertNotNull(product);
        System.out.println(product.toString());
        productService.delete(product, false);
    }

    @Test
    public void testGetClient(){
        Product product = new Product();
        product.setName("Test Product2");
        Category category = new Category();
        category  = categoryService.getCategory(12, false);
        product.setCategory(category);
        product.setCode("1234");
        product.setDescription("Description for test product");
        Supplier supplier = new Supplier();
        supplier = supplierService.getSupplier(1, false);
        product.setSupplier(supplier);

        product = productService.create(product, false);
        assertNotNull(productService.getProduct(product.getId(), false));
        System.out.println(product.toString());
        productService.delete(product, false);
    }

    @Test
    public void testFindAll(){
        Product product = new Product();
        product.setName("Test Product2");
        Category category = new Category();
        category  = categoryService.getCategory(12, false);
        product.setCategory(category);
        product.setCode("1234");
        product.setDescription("Description for test product");
        Supplier supplier = new Supplier();
        supplier = supplierService.getSupplier(1, false);
        product.setSupplier(supplier);
        productService.create(product, false);

        Product product1 = new Product();
        product1.setName("Test Product2");
        category  = categoryService.getCategory(12, false);
        product1.setCategory(category);
        product1.setCode("8765");
        product1.setDescription("Description for test product2");
        Supplier supplier1 = new Supplier();
        supplier1 = supplierService.getSupplier(2, false);
        product1.setSupplier(supplier1);
        productService.create(product1, false);

        List<Product> productList = new ArrayList<>();
        productList = productService.findAll(false);
        assertNotNull(productList);
        productList.forEach(System.out::println);
        productService.delete(product, false);
        productService.delete(product1, false);
    }

    @Test
    public void testGetCertainProducts(){
        List<Product> productList = new ArrayList<>();
        productList = productService.getCertainProducts("Electronics", 1L, 1L);
        //assertNotNull(productList);
        productList.forEach(System.out::println);

    }

    @Test
    public void testDelete(){
        Product product = new Product();
        product.setName("Test Product2");
        Category category = new Category();
        category  = categoryService.getCategory(12, false);
        product.setCategory(category);
        product.setCode("1234");
        product.setDescription("Description for test product");
        Supplier supplier = new Supplier();
        supplier = supplierService.getSupplier(1, false);
        product.setSupplier(supplier);
        product = productService.create(product, false);
        productService.delete(product, false);
        assertNull(productService.getProduct(product.getId(), false));
    }

}
