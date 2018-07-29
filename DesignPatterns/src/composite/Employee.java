package composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void add(Employee employee) {
        if (subordinates == null) {
            subordinates = new ArrayList<>();
        }
        subordinates.add(employee);
    }

    public void remove(Employee employee) {
        if(subordinates == null){
            throw new IllegalArgumentException("Subordinate list not initialized");
        }
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String printEmployeeAndSubordinates() {
        String allEmp = "";
        String head = toString();
        allEmp = allEmp + head + "\n";
        allEmp = allEmp + getAllEmployees(allEmp, getSubordinates());
//        if (getSubordinates() == null) {
//            return allEmp;
//        }
//        for (Employee employee : getSubordinates()) {
//            allEmp = allEmp + employee.toString() + "\n";
//            if (employee.getSubordinates() == null) {
//                continue;
//            } else {
//                for (Employee employee1 : employee.getSubordinates()) {
//                    allEmp = allEmp + employee1.toString() + "\n";
//                }
//            }
//        }
        return allEmp;
    }

    private String getAllEmployees(String employees, List<Employee> employeeList){
        for(Employee employee:employeeList){
            employees = employees + employee.toString() + "\n";
            if(employee.getSubordinates() == null){
                continue;
            } else {
                employees = employees + getAllEmployees(employees, employee.getSubordinates());
                return employees;
            }
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name: " + name + ", dept:" +
                dept + ", salary:" + salary + "]";
    }


}
