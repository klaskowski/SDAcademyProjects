package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.StockDAO;
import ro.sda.hypermarket.core.entity.Stock;
import ro.sda.hypermarket.core.repository.StockRepository;

import java.util.List;

@Service("stockService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StockServiceImpl implements StockService{

    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock create(Stock stock, boolean useHibernate) {
        if(useHibernate) {
            return stockDAO.create(stock);
        }
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Stock stock, boolean useHibernate) {
        if(useHibernate) {
            return stockDAO.update(stock);
        }
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStock(long id, boolean useHibernate) {
        if(useHibernate) {
            return stockDAO.getStock(id);
        }
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> findAll(boolean useHibernate) {
        if(useHibernate) {
            return stockDAO.findAll();
        }
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getAllFromStock(String category) {
        return stockDAO.getAllFromStock(category);
    }

    @Override
    public void delete(Stock stock, boolean useHibernate) {
        if(useHibernate) {
            stockDAO.delete(stock);
        } else {
            stockRepository.delete(stock);
        }
    }
}
