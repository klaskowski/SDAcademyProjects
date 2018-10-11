package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testCreate(){
        Supplier supplier = new Supplier();
        supplier.setName("TestSupplierSpringData11");
        supplier.setBankAccount("SupplierAccountSpringData11");
        supplier.setEmail("contact@supplier11SpringData.nz");

        supplier = supplierService.create(supplier, false);

        assertNotNull(supplier.getId());
        supplierService.delete(supplier, false);
    }

    @Test
    public void testUpdate(){
        Supplier supplier1 = supplierService.getSupplier(17, false);
        supplier1.setEmail("updatedEmail@supplier1.ro");
        supplierService.update(supplier1, false);
        System.out.println(supplier1.toString());
        assertTrue(supplier1.getEmail().equals("updatedEmail@supplier1.ro"));
        supplierService.delete(supplier1, false);
    }

    @Test
    public void testGetSupplier(){
        Supplier supplier= new Supplier();
        supplier.setName("TestSupplierSData");
        supplier.setBankAccount("SupplierAccountSData1");
        supplier.setEmail("contact@supplierSData1.ro");

        supplier = supplierService.create(supplier, false);

        assertNotNull(supplierService.getSupplier(supplier.getId(), false));
        System.out.println(supplier.toString());
        supplierService.delete(supplier, false);
    }

    @Test
    public void testFindByName(){
        Supplier supplier = supplierService.findByName("Panifcom", false);
        assertNotNull(supplier);
        System.out.println(supplier.toString());
    }

    @Test
    public void testFindAll(){
//        Supplier supplier1 = new Supplier();
//        supplier1.setName("Supplier1");
//        supplier1.setBankAccount("SupplierAccount1");
//        supplier1.setEmail("contact@supplier1.ro");
//        supplier1 = supplierService.create(supplier1, false);
//
//        Supplier supplier2 = new Supplier();
//        supplier2.setName("Supplier2");
//        supplier2.setBankAccount("SupplierAccount2");
//        supplier2.setEmail("contact@supplier2.ro");
//        supplier2 = supplierService.create(supplier2, false);

        List<Supplier> supplierList = new ArrayList<Supplier>();
        supplierList = supplierService.findAll(false);
        assertNotNull(supplierList);
        supplierList.forEach(System.out::println);
//        supplierService.delete(supplier1);
//        supplierService.delete(supplier2);
    }

    @Test
    public void testDelete(){
        Supplier supplier0 = new Supplier();
        supplier0.setName("SupplierTestSD22");
        supplier0.setBankAccount("SupplierAccount23TestSD22");
        supplier0.setEmail("contact@supplier23TestSD22.ro");
        supplierService.create(supplier0, false);

        supplierService.delete(supplier0, false);

        assertNull(supplierService.getSupplier(supplier0.getId(), false));
    }
}
