package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.StockDAO;
import ro.sda.hypermarket.core.entity.Stock;

import java.util.List;

@Service("stockService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StockServiceImpl implements StockService{

    @Autowired
    private StockDAO stockDAO;

    @Override
    public Stock create(Stock stock) {
        return stockDAO.create(stock);
    }

    @Override
    public Stock update(Stock stock) {
        return stockDAO.update(stock);
    }

    @Override
    public Stock getStock(long id) {
        return stockDAO.getStock(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockDAO.findAll();
    }

    @Override
    public List<Stock> getAllFromStock(String category) {
        return stockDAO.getAllFromStock(category);
    }

    @Override
    public void delete(Stock stock) {
        stockDAO.delete(stock);
    }
}
