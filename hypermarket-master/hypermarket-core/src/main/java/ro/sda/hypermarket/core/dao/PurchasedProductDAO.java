package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.PurchasedProduct;

import java.util.List;

public interface PurchasedProductDAO extends AbstractDAO {

    public PurchasedProduct create(PurchasedProduct purchasedProduct);

    public PurchasedProduct update (PurchasedProduct purchasedProduct);

    public PurchasedProduct getPurchasedProduct(long id);

    public List<PurchasedProduct> findAll();

    public void delete(PurchasedProduct purchasedProduct);
}
