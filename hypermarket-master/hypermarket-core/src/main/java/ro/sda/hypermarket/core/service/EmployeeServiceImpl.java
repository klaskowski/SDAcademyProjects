package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.EmployeeRepository;

import java.util.List;

@Service("employeeService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee, boolean useHibernate) {
        if(useHibernate) {
            return employeeDAO.create(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee, boolean useHibernate) {
        if(useHibernate) {
            return employeeDAO.update(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(long id, boolean useHibernate) {
        if(useHibernate) {
            return employeeDAO.getEmployee(id);
        }
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll(boolean useHibernate) {
        if(useHibernate) {
            return employeeDAO.findAll();
        }
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Employee employee, boolean useHibernate) {
        if(useHibernate) {
            employeeDAO.delete(employee);
        } else {
            employeeRepository.delete(employee);
        }
    }
}
