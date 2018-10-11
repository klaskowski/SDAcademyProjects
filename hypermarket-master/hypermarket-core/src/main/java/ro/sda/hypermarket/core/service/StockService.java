package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Stock;

import java.util.List;

public interface StockService {
    public Stock create(Stock stock, boolean useHibernate);

    public Stock update(Stock stock, boolean useHibernate);

    public Stock getStock(long id, boolean useHibernate);

    public List<Stock> findAll(boolean useHibernate);

    public List<Stock> getAllFromStock(String category);

    public void delete(Stock stock, boolean useHibernate);
}
