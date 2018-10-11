package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

public interface ProductService {

    public Product create(Product product, boolean useHibernate);

    public Product update (Product product, boolean useHibernate);

    public Product getProduct(long id, boolean useHibernate);

    public List<Product> findAll(boolean useHibernate);

    public List<Product> getCertainProducts(String category, Long suppId, Long clId);

    public void delete(Product product, boolean useHibernate);
}
