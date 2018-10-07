package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.PurchasedProductDAO;
import ro.sda.hypermarket.core.entity.PurchasedProduct;

import java.util.List;

@Service("purchasedProductService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PurchasedProductServiceImpl implements PurchasedProductService{

    @Autowired
    private PurchasedProductDAO purchasedProductDAO;

    @Override
    public PurchasedProduct create(PurchasedProduct purchasedProduct) {
        return purchasedProductDAO.create(purchasedProduct);
    }

    @Override
    public PurchasedProduct update(PurchasedProduct purchasedProduct) {
        return purchasedProductDAO.update(purchasedProduct);
    }

    @Override
    public PurchasedProduct getPurchasedProduct(long id) {
        return purchasedProductDAO.getPurchasedProduct(id);
    }

    @Override
    public List<PurchasedProduct> findAll() {
        return purchasedProductDAO.findAll();
    }

    @Override
    public void delete(PurchasedProduct purchasedProduct) {
        purchasedProductDAO.delete(purchasedProduct);
    }
}
