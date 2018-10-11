package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category create(Category category, boolean useHibernate);
    public Category update(Category category, boolean useHibernate);
    public Category getCategory(long id, boolean useHibernate);
    public List<Category> findAll(boolean useHibernate);
    public Category findByName(String categoryName, boolean useHibernate);
    public void delete(Category category, boolean useHibernate);
}
