package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Category create(Category category) {
        getCurrentSession().save(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        Transaction tr = getCurrentSession().beginTransaction();
        getCurrentSession().update(category);
        getCurrentSession().flush();
        tr.commit();
        return category;
    }

    @Override
    public Category getCategory(long id) {
        Category searchedCategory = getCurrentSession().get(Category.class, id);
        return searchedCategory;
    }

    @Override
    public List<Category> findAll() {
        CriteriaQuery<Category> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(Category.class);
        criteriaQuery.from(Category.class);
        List<Category> categoryList = getCurrentSession().createQuery(criteriaQuery).getResultList();
        return categoryList;
    }

    @Override
    public Category findByName(String categoryName) {
        Query query = getCurrentSession().createQuery("from Category where name= :name");
        query.setParameter("name", categoryName);
        Category found = (Category) query.uniqueResult();
        return found;
    }

    @Override
    public void delete(Category category) {
        Transaction tr = getCurrentSession().beginTransaction();
        Category found = (Category) getCurrentSession().get(Category.class, category.getId());
        getCurrentSession().delete(found);
        getCurrentSession().flush();
        tr.commit();
    }

}
