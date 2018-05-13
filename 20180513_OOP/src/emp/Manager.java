package emp;

import java.util.Date;

public class Manager extends SalariedEmp {

    public Manager(String name) {
        super(name);
    }

    @Override
    public double getSalary() {
        return 5000.00;
    }

    @Override
    public void sayName() {
        System.out.println("Manager name: " + name);
    }

    public void hire(Department department, Employee employee) {
        employee.setHireDate(new Date());
        department.addEmp(employee);
    }

    public double getPayAmount() {
        return getSalary();
    }
}
