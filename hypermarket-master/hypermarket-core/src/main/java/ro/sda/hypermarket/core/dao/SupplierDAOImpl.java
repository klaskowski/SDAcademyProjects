package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Supplier create(Supplier supplier) {
        getCurrentSession().save(supplier);
        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(supplier);
        getCurrentSession().flush();
        tr.commit();
        return supplier;
    }

    @Override
    public Supplier getSupplier(long id) {
        Supplier searchedSupplier = getCurrentSession().get(Supplier.class, id);
        return searchedSupplier;
    }

    @Override
    public Supplier findByName(String supplierName) {
        Query query = getCurrentSession().createQuery("from Supplier where name= :name");
        query.setParameter("name", supplierName);
        Supplier found = (Supplier) query.uniqueResult();
        return found;
    }

    @Override
    public List<Supplier> findAll() {
        CriteriaQuery<Supplier> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Supplier.class);
        criteriaQuery.from(Supplier.class);
        List<Supplier> supplierList = getCurrentSession().createQuery(criteriaQuery).getResultList();

        //List<Supplier> supplierList = getCurrentSession().createCriteria(Supplier.class).list();
        return supplierList;
    }

    @Override
    public void delete(Supplier supplier) {
        Transaction tr = getCurrentSession().beginTransaction();
        Supplier found = (Supplier) getCurrentSession().get(Supplier.class, supplier.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }
}
