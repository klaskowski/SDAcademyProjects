package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductDAO extends AbstractDAO {

    public Product create(Product product);

    public Product update(Product product);

    public Product getProduct(long id);

    public List<Product> findAll();

    public List<Product> getCertainProducts(String category, Long suppId, Long clId);

    public void delete(Product product);
}
