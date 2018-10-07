package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Stock;
import ro.sda.hypermarket.core.service.ProductService;
import ro.sda.hypermarket.core.service.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private ProductService productService;

    @Test
    public void testCreate(){
        Stock stock = new Stock();
        Product product = productService.getProduct(8);
        stock.setProduct(product);
        stock.setAcquisitionCost(25);
        stock.setBatchNo("1");
        stock.setSellingCost(35);
        stock.setStockAmount(100);
        stock = stockService.create(stock);
        assertNotNull(stock);
        stockService.delete(stock);
    }

    @Test
    public void testUpdate(){
        Stock stock = new Stock();
        Product product = productService.getProduct(8);
        stock.setProduct(product);
        stock.setAcquisitionCost(25);
        stock.setBatchNo("1");
        stock.setSellingCost(35);
        stock.setStockAmount(100);
        stock = stockService.create(stock);
        stock.setSellingCost(75);
        stockService.update(stock);
        assertTrue(stock.getSellingCost() == 75);
        stockService.delete(stock);
    }

    @Test
    public void testGetStock(){
        Stock stock = new Stock();
        Product product = productService.getProduct(8);
        stock.setProduct(product);
        stock.setAcquisitionCost(25);
        stock.setBatchNo("1");
        stock.setSellingCost(35);
        stock.setStockAmount(100);
        stock = stockService.create(stock);
        assertNotNull(stockService.getStock(stock.getId()));
        stockService.delete(stock);
    }

    @Test
    public void testDelete(){
        Stock stock = new Stock();
        Product product = productService.getProduct(8);
        stock.setProduct(product);
        stock.setAcquisitionCost(25);
        stock.setBatchNo("1");
        stock.setSellingCost(35);
        stock.setStockAmount(100);
        stock = stockService.create(stock);
        stockService.delete(stock);
        assertNull(stockService.getStock(stock.getId()));
    }

    @Test
    public void testGetAllFromSTock(){
        List<Stock> stockList = new ArrayList<>();
        stockList = stockService.getAllFromStock("Electronics");
        assertNotNull(stockList);
        stockList.forEach(System.out::println);
    }

    @Test
    public void testFindAll(){
        Stock stock = new Stock();
        Product product = productService.getProduct(8);
        stock.setProduct(product);
        stock.setAcquisitionCost(25);
        stock.setBatchNo("1");
        stock.setSellingCost(35);
        stock.setStockAmount(100);
        stock = stockService.create(stock);

        Stock stock1 = new Stock();
        stock1.setProduct(product);
        stock1.setAcquisitionCost(39);
        stock1.setBatchNo("6");
        stock1.setSellingCost(987);
        stock1.setStockAmount(1000);
        stock1 = stockService.create(stock1);
        List<Stock> stockList = stockService.findAll();
        assertNotNull(stockList);
        stockList.forEach(System.out::println);
        stockService.delete(stock);
        stockService.delete(stock1);
    }
}
