package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Employee;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Employee create(Employee employee) {
        getCurrentSession().save(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(employee);
        getCurrentSession().flush();
        tr.commit();
        return employee;
    }

    @Override
    public Employee getEmployee(long id) {
        Employee searchedEmployee = getCurrentSession().get(Employee.class, id);
        return searchedEmployee;
    }

    @Override
    public List<Employee> findAll() {
        CriteriaQuery<Employee> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Employee.class);
        criteriaQuery.from(Employee.class);
        List<Employee> employeeList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    @Override
    public void delete(Employee employee) {
        Transaction tr = getCurrentSession().beginTransaction();
        Employee found = (Employee) getCurrentSession().get(Employee.class, employee.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }


}
