package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.CategoryDAO;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.repository.CategoryRepository;

import java.util.List;

@Service("categoryService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category, boolean useHibernate) {
        if(useHibernate) {
            return categoryDAO.create(category);
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category,boolean useHibernate) {
        if(useHibernate) {
            return categoryDAO.update(category);
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long id, boolean useHibernate) {
        if(useHibernate) {
            return categoryDAO.getCategory(id);
        }
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll(boolean useHibernate) {
        if(useHibernate) {
            return categoryDAO.findAll();
        }
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String categoryName, boolean useHibernate) {
        if(useHibernate) {
            return categoryDAO.findByName(categoryName);
        }
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public void delete(Category category, boolean useHibernate) {
        if(useHibernate) {
            categoryDAO.delete(category);
        } else {
            categoryRepository.delete(category);
        }
    }
}
