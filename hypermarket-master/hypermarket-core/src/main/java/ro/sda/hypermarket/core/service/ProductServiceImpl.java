package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.entity.Product;

import java.util.List;

@Service("productService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Product update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public Product getProduct(long id) {
        return productDAO.getProduct(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> getCertainProducts(String category, Long suppId, Long clId){
        return productDAO.getCertainProducts(category, suppId, clId);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }
}
