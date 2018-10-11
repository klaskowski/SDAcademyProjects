package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierService {

    public Supplier create(Supplier supplier, boolean useHibernate);

    public Supplier update (Supplier supplier, boolean useHibernate);

    public Supplier getSupplier(long id, boolean useHibernate);

    public Supplier findByName(String supplierName, boolean useHibernate);

    public List<Supplier> findAll(boolean useHibernate);

    public void delete(Supplier supplier, boolean useHibernate);


}
