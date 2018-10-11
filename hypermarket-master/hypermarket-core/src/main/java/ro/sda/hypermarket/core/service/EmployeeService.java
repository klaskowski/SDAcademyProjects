package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee create(Employee employee, boolean useHibernate);

    public Employee update (Employee employee, boolean useHibernate);

    public Employee getEmployee(long id, boolean useHibernate);

    public List<Employee> findAll(boolean useHibernate);

    public void delete(Employee employee, boolean useHibernate);
}
