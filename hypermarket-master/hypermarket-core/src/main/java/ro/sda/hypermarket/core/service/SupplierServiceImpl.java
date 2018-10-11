package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDAO;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.SupplierRepository;

import java.util.List;

@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public Supplier create(Supplier supplier, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.create(supplier);
        }
        return supplierRepository.save(supplier);
    }

    @Override
    @Transactional
    public Supplier update(Supplier supplier, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.update(supplier);
        } return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplier(long id, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.getSupplier(id);
        }
        return supplierRepository.findById(id);
    }

    @Override
    public Supplier findByName(String supplierName, boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.findByName(supplierName);
        } return supplierRepository.findByName(supplierName);
    }

    @Override
    public List<Supplier> findAll(boolean useHibernate) {
        if(useHibernate) {
            return supplierDAO.findAll();
        }
        return supplierRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Supplier supplier, boolean useHibernate){
        if(useHibernate) {
            supplierDAO.delete(supplier);
        } else{
            supplierRepository.delete(supplier);
        }
    }

}
