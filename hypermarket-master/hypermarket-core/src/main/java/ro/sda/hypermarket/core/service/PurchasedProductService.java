package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.PurchasedProduct;

import java.util.List;

public interface PurchasedProductService {

    public PurchasedProduct create(PurchasedProduct purchasedProduct);

    public PurchasedProduct update (PurchasedProduct purchasedProduct);

    public PurchasedProduct getPurchasedProduct(long id);

    public List<PurchasedProduct> findAll();

    public void delete(PurchasedProduct purchasedProduct);
}
