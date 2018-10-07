package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.base.AbstractDAO;
import ro.sda.hypermarket.core.entity.Stock;

import java.util.List;

public interface StockDAO extends AbstractDAO {

    public Stock create(Stock stock);

    public Stock update(Stock stock);

    public Stock getStock(long id);

    public List<Stock> findAll();

    public List<Stock> getAllFromStock(String category);

    public void delete(Stock stock);

}
