package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.PurchasedProduct;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class PurchasedProductDAOImpl implements PurchasedProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public PurchasedProduct create(PurchasedProduct purchasedProduct) {
        getCurrentSession().save(purchasedProduct);
        return purchasedProduct;
    }

    @Override
    public PurchasedProduct update(PurchasedProduct purchasedProduct) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(purchasedProduct);
        getCurrentSession().flush();
        tr.commit();
        return purchasedProduct;
    }

    @Override
    public PurchasedProduct getPurchasedProduct(long id) {
        PurchasedProduct searchedPurchasedProduct = getCurrentSession().get(PurchasedProduct.class, id);
        return searchedPurchasedProduct;
    }

    @Override
    public List<PurchasedProduct> findAll() {
        CriteriaQuery<PurchasedProduct> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(PurchasedProduct.class);
        criteriaQuery.from(PurchasedProduct.class);
        List<PurchasedProduct> purchasedProductList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return purchasedProductList;
    }

    @Override
    public void delete(PurchasedProduct purchasedProduct) {
        Transaction tr = getCurrentSession().beginTransaction();
        PurchasedProduct found = (PurchasedProduct) getCurrentSession().get(PurchasedProduct.class, purchasedProduct.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }

}
