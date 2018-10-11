package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProductDAO;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.repository.ProductRepository;

import java.util.List;

@Service("productService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product, boolean useHibernate) {
        if(useHibernate) {
            return productDAO.create(product);
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, boolean useHibernate) {
        if(useHibernate) {
            return productDAO.update(product);
        }
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(long id, boolean useHibernate) {
        if(useHibernate) {
            return productDAO.getProduct(id);
        }
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll(boolean useHibernate) {
        if(useHibernate) {
            return productDAO.findAll();
        }
        return productRepository.findAll();
    }

    @Override
    public List<Product> getCertainProducts(String category, Long suppId, Long clId){
        return productDAO.getCertainProducts(category, suppId, clId);
    }

    @Override
    public void delete(Product product, boolean useHibernate) {
        if(useHibernate) {
            productDAO.delete(product);
        } else{
            productRepository.delete(product);
        }
    }
}
