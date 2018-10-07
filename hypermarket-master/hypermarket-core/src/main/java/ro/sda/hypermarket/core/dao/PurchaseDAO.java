package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.Purchase;

import java.util.List;

public interface PurchaseDAO extends AbstractDAO {

    public Purchase create(Purchase purchase);

    public Purchase update(Purchase purchase);

    public Purchase getPurchase(long id);

    public List<Purchase> findAll();

    public void delete(Purchase purchase);
}
