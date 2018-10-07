package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Purchase;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class PurchaseDAOImpl implements PurchaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
}

    @Override
    public Purchase create(Purchase purchase) {
        getCurrentSession().save(purchase);
        return purchase;
    }

    @Override
    public Purchase update(Purchase purchase) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(purchase);
        getCurrentSession().flush();
        tr.commit();
        return purchase;
    }

    @Override
    public Purchase getPurchase(long id) {
        Purchase searchedPurchase = getCurrentSession().get(Purchase.class, id);
        return searchedPurchase;
    }

    @Override
    public List<Purchase> findAll() {
        CriteriaQuery<Purchase> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Purchase.class);
        criteriaQuery.from(Purchase.class);
        List<Purchase> purchaseList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return purchaseList;
    }

    @Override
    public void delete(Purchase purchase) {
        Transaction tr = getCurrentSession().beginTransaction();
        Purchase found = (Purchase) getCurrentSession().get(Purchase.class, purchase.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }


}
