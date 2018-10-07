package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Stock;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StockDAOImpl implements StockDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Stock create(Stock stock) {
        getCurrentSession().save(stock);
        return stock;
    }

    @Override
    public Stock update(Stock stock) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(stock);
        getCurrentSession().flush();
        tr.commit();
        return stock;
    }

    @Override
    public Stock getStock(long id) {
        Stock searchedStock = getCurrentSession().get(Stock.class, id);
        return searchedStock;
    }

    @Override
    public List<Stock> findAll() {
        CriteriaQuery<Stock> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Stock.class);
        criteriaQuery.from(Stock.class);
        List<Stock> stockList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return stockList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stock> getAllFromStock(String category) {
        Query query = getCurrentSession().createQuery("SELECT s FROM Stock s INNER JOIN Product p ON s.product.id = p.id INNER JOIN Category c ON p.category.id = c.id WHERE c.name LIKE :category");
        //Query query = getCurrentSession().createQuery("SELECT s from Stock s WHERE s.product.category.name = :category");
        query.setParameter("category", category);
        List<Stock> stockList = new ArrayList<>();
        stockList = (List<Stock>) query.list();
        return stockList;
    }

    @Override
    public void delete(Stock stock) {
        Transaction tr = getCurrentSession().beginTransaction();
        Stock found = (Stock) getCurrentSession().get(Stock.class, stock.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }

}
