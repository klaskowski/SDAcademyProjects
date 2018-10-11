package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.PurchasedProductDAO;
import ro.sda.hypermarket.core.entity.PurchasedProduct;
import ro.sda.hypermarket.core.repository.PurchaseProductRepository;

import java.util.List;

@Service("purchasedProductService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PurchasedProductServiceImpl implements PurchasedProductService{

    @Autowired
    private PurchasedProductDAO purchasedProductDAO;

    @Autowired
    protected PurchaseProductRepository purchaseProductRepository;

    @Override
    public PurchasedProduct create(PurchasedProduct purchasedProduct, boolean useHibernate) {
        if(useHibernate) {
            return purchasedProductDAO.create(purchasedProduct);
        }
        return purchaseProductRepository.save(purchasedProduct);
    }

    @Override
    public PurchasedProduct update(PurchasedProduct purchasedProduct,boolean useHibernate) {
        if(useHibernate) {
            return purchasedProductDAO.update(purchasedProduct);
        }
        return purchaseProductRepository.save(purchasedProduct);
    }

    @Override
    public PurchasedProduct getPurchasedProduct(long id, boolean useHibernate) {
        if(useHibernate) {
            return purchasedProductDAO.getPurchasedProduct(id);
        }
        return purchaseProductRepository.findById(id);
    }

    @Override
    public List<PurchasedProduct> findAll(boolean useHibernate) {
        if(useHibernate) {
            return purchasedProductDAO.findAll();
        }
        return purchaseProductRepository.findAll();
    }

    @Override
    public void delete(PurchasedProduct purchasedProduct, boolean useHibernate) {
        if(useHibernate) {
            purchasedProductDAO.delete(purchasedProduct);
        } else {
            purchaseProductRepository.delete(purchasedProduct);
        }
    }
}
