package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public Supplier create(Supplier supplier);

    public Supplier update (Supplier supplier);

    public Supplier getSupplier(long id);

    public Supplier findByName(String supplierName);

    public List<Supplier> findAll();

    public void delete(Supplier supplier);
}
