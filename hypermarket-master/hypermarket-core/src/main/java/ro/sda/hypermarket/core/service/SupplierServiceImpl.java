package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDAO supplierDAO;

    @Override
    public Supplier create(Supplier supplier) {
        return supplierDAO.create(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierDAO.update(supplier);
    }

    @Override
    public Supplier getSupplier(long id) {
        return supplierDAO.getSupplier(id);
    }

    @Override
    public Supplier findByName(String supplierName) {
        return supplierDAO.findByName(supplierName);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierDAO.findAll();
    }

    @Override
    public void delete(Supplier supplier){
        supplierDAO.delete(supplier);
    }
}
