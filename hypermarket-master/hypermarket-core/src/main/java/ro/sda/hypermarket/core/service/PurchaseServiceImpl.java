package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.PurchaseDAO;
import ro.sda.hypermarket.core.entity.Purchase;

import java.util.List;

@Service("purchaseService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;

    @Override
    public Purchase create(Purchase purchase) {
        return purchaseDAO.create(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        return purchaseDAO.update(purchase);
    }

    @Override
    public Purchase getPurchase(long id) {
        return purchaseDAO.getPurchase(id);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseDAO.findAll();
    }

    @Override
    public void delete(Purchase purchase) {
        purchaseDAO.delete(purchase);
    }
}
