package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.PurchaseDAO;
import ro.sda.hypermarket.core.entity.Purchase;
import ro.sda.hypermarket.core.repository.PurchaseRepository;

import java.util.List;

@Service("purchaseService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDAO purchaseDAO;

    @ Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase create(Purchase purchase, boolean useHibernate) {
        if(useHibernate) {
            return purchaseDAO.create(purchase);
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase, boolean useHibernate) {
        if(useHibernate) {
            return purchaseDAO.update(purchase);
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase getPurchase(long id, boolean useHibernate) {
        if(useHibernate) {
            return purchaseDAO.getPurchase(id);
        }
        return purchaseRepository.findById(id);
    }

    @Override
    public List<Purchase> findAll(boolean useHibernate) {
        if(useHibernate) {
            return purchaseDAO.findAll();
        }
        return purchaseRepository.findAll();
    }

    @Override
    public void delete(Purchase purchase, boolean useHibernate) {
        if(useHibernate) {
            purchaseDAO.delete(purchase);
        } else {
            purchaseRepository.delete(purchase);
        }
    }
}
