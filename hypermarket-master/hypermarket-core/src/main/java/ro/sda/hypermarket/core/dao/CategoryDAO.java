package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.Category;

import java.util.List;

public interface CategoryDAO extends AbstractDAO {

    public Category create(Category category);
    public Category update(Category category);
    public Category getCategory(long id);
    public List<Category> findAll();
    public Category findByName(String categoryName);
    public void delete(Category category);

}
