package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends AbstractDAO {
    public Employee create(Employee employee);
    public Employee update(Employee employee);
    public Employee getEmployee(long id);
    public void delete(Employee employee);
    public List<Employee> findAll();
}
