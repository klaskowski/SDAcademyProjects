package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.service.EmployeeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreate(){
        Employee employee = new Employee();
        employee.setFirstName("FN1");
        employee.setLastName("LN1");
        employee.setCode("ABCD");
        employee.setPosition("POS1");
        employee.setBirthDate(new Date(1984, 1, 17));
        employee.setCnp("1234567891230");
        employee.setAddress("Home1");
        employee.setEmail("em@email.ro");
        employee.setPhoneNo("0745896312");

        employeeService.create(employee, false);
        assertNotNull(employee.getId());
        employeeService.delete(employee, false);
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setFirstName("FN6");
        employee.setLastName("LN6");
        employee.setCode("SEUT");
        employee.setPosition("POS8");
        employee.setBirthDate(new Date(1984, 8, 15));
        employee.setCnp("9312765098712");
        employee.setAddress("Home8");
        employee.setEmail("em@email98.ro");
        employee.setPhoneNo("6541230987");

        employeeService.create(employee, false);
        System.out.println(employee.toString());
        employee.setLastName("UpdatedLN");
        employee.setFirstName("updatedFN");
        employeeService.update(employee, false);
        System.out.println(employee.toString());
        assertTrue(employee.getFirstName().equals("updatedFN"));
        employeeService.delete(employee, false);
    }

    @Test
    public void testGetEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("FN1");
        employee.setLastName("LN1");
        employee.setCode("ABKD");
        employee.setPosition("POS3");
        employee.setBirthDate(new Date(1984, 1, 17));
        employee.setCnp("1234567891231");
        employee.setAddress("Home1");
        employee.setEmail("em@email.ro");
        employee.setPhoneNo("0745896316");

        employeeService.create(employee, false);
        assertNotNull(employeeService.getEmployee(employee.getId(), false));
        System.out.println(employee.toString());
        employeeService.delete(employee, false);
    }

    @Test
    public void testFindAll(){
        Employee employee1 = new Employee();
        employee1.setFirstName("FN1");
        employee1.setLastName("LN1");
        employee1.setCode("ACCD");
        employee1.setPosition("POS3");
        employee1.setBirthDate(new Date(1984, 1, 17));
        employee1.setCnp("9234567891230");
        employee1.setAddress("Home1");
        employee1.setEmail("em@email.ro");
        employee1.setPhoneNo("2745896312");
        employeeService.create(employee1, false);

        Employee employee2 = new Employee();
        employee2.setFirstName("FN2");
        employee2.setLastName("LN2");
        employee2.setCode("ABFR");
        employee2.setPosition("POS2");
        employee2.setBirthDate(new Date(1984, 1, 10));
        employee2.setCnp("1234567898760");
        employee2.setAddress("Home2");
        employee2.setEmail("em2@email.ro");
        employee2.setPhoneNo("0741296312");
        employeeService.create(employee2, false);

        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.findAll(false);
        assertNotNull(employeeList);
        employeeList.forEach(System.out::println);
        employeeService.delete(employee1, false);
        employeeService.delete(employee2, false);
    }

    @Test
    public void testDelete(){
        Employee employee2 = new Employee();
        employee2.setFirstName("FN2");
        employee2.setLastName("LN2");
        employee2.setCode("ABFR");
        employee2.setPosition("POS2");
        employee2.setBirthDate(new Date(1984, 1, 10));
        employee2.setCnp("1234567898760");
        employee2.setAddress("Home2");
        employee2.setEmail("em2@email.ro");
        employee2.setPhoneNo("0741296312");
        employeeService.create(employee2, false);

        employeeService.delete(employee2, false);

        assertNull(employeeService.getEmployee(employee2.getId(), false));

    }

}
