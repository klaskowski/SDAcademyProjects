package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Purchase;
import ro.sda.hypermarket.core.service.ClientService;
import ro.sda.hypermarket.core.service.EmployeeService;
import ro.sda.hypermarket.core.service.PurchaseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreate(){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client = clientService.getClient(1, false);
        purchase.setClient(client);
        Employee employee = new Employee();
        employee = employeeService.getEmployee(2, false);
        purchase.setEmployee(employee);
        purchase.setPurchaseDate(new Date(2017,10,10));
        purchase.setReceiptNo(5);
        purchase.setTotalPrice(9650);
        purchase = purchaseService.create(purchase, false);
        assertNotNull(purchase);
        System.out.println(purchase);
        purchaseService.delete(purchase, false);
    }

    @Test
    public void testUpdate(){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client = clientService.getClient(1, false);
        purchase.setClient(client);
        Employee employee = new Employee();
        employee = employeeService.getEmployee(2, false);
        purchase.setEmployee(employee);
        purchase.setPurchaseDate(new Date(2018,10,25));
        purchase.setReceiptNo(1);
        purchase.setTotalPrice(5000);
        purchase = purchaseService.create(purchase, false);
        purchase.setTotalPrice(7000);
        purchase = purchaseService.update(purchase, false);
        System.out.println(purchase);
        purchaseService.delete(purchase, false);
    }

    @Test
    public void testGetPurchase(){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client = clientService.getClient(1, false);
        purchase.setClient(client);
        Employee employee = new Employee();
        employee = employeeService.getEmployee(2, false);
        purchase.setEmployee(employee);
        purchase.setPurchaseDate(new Date(2018,10,25));
        purchase.setReceiptNo(1);
        purchase.setTotalPrice(5000);
        purchase = purchaseService.create(purchase, false);

        assertNotNull(purchaseService.getPurchase(purchase.getId(), false));
        purchaseService.delete(purchase, false);
    }

    @Test
    public void testDelete(){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client = clientService.getClient(1, false);
        purchase.setClient(client);
        Employee employee = new Employee();
        employee = employeeService.getEmployee(2, false);
        purchase.setEmployee(employee);
        purchase.setPurchaseDate(new Date(2018,10,25));
        purchase.setReceiptNo(1);
        purchase.setTotalPrice(5000);
        purchase = purchaseService.create(purchase, false);
        purchaseService.delete(purchase, false);
        assertNull(purchaseService.getPurchase(purchase.getId(), false));
    }

    @Test
    public void testFindAll(){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client = clientService.getClient(1, false);
        purchase.setClient(client);
        Employee employee = new Employee();
        employee = employeeService.getEmployee(2, false);
        purchase.setEmployee(employee);
        purchase.setPurchaseDate(new Date(2018,10,25));
        purchase.setReceiptNo(1);
        purchase.setTotalPrice(5000);
        purchase = purchaseService.create(purchase, false);

        Purchase purchase1 = new Purchase();
        client = clientService.getClient(1, false);
        purchase1.setClient(client);
        employee = employeeService.getEmployee(2, false);
        purchase1.setEmployee(employee);
        purchase1.setPurchaseDate(new Date(2018,10,29));
        purchase1.setReceiptNo(2);
        purchase1.setTotalPrice(89000);
        purchase1 = purchaseService.create(purchase1, false);

        List<Purchase> purchaseList = new ArrayList<>();
        purchaseList = purchaseService.findAll(false);
        assertNotNull(purchaseList);
        purchaseList.forEach(System.out::println);
        purchaseService.delete(purchase, false);
        purchaseService.delete(purchase1, false);
        }


}
