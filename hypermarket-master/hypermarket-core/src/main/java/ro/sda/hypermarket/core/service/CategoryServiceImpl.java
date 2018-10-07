package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.CategoryDAO;
import ro.sda.hypermarket.core.entity.Category;

import java.util.List;

@Service("categoryService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category create(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public Category getCategory(long id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryDAO.findByName(categoryName);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category);
    }
}
