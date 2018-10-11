package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Purchase;

import java.util.List;

public interface PurchaseService {

    public Purchase create(Purchase purchase, boolean useHibernate);

    public Purchase update(Purchase purchase, boolean useHibernate);

    public Purchase getPurchase(long id, boolean useHibernate);

    public List<Purchase> findAll(boolean useHibernate);

    public void delete(Purchase purchase, boolean useHibernate);

}
