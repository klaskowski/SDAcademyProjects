package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee create(Employee employee);

    public Employee update (Employee employee);

    public Employee getEmployee(long id);

    public List<Employee> findAll();

    public void delete(Employee employee);
}
