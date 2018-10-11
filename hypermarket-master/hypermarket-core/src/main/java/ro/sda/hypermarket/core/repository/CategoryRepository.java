package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Category;

public interface CategoryRepository extends EntityRepository<Category> {
    public Category findByName(String categoryName);
}
