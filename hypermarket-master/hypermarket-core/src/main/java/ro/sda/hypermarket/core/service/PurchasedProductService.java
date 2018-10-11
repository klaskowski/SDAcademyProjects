package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.PurchasedProduct;

import java.util.List;

public interface PurchasedProductService {

    public PurchasedProduct create(PurchasedProduct purchasedProduct, boolean useHibernate);

    public PurchasedProduct update (PurchasedProduct purchasedProduct, boolean useHibernate);

    public PurchasedProduct getPurchasedProduct(long id, boolean useHibernate);

    public List<PurchasedProduct> findAll(boolean useHibernate);

    public void delete(PurchasedProduct purchasedProduct, boolean useHibernate);
}
