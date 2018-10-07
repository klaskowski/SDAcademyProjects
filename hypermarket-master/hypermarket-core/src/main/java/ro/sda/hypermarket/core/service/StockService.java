package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Stock;

import java.util.List;

public interface StockService {
    public Stock create(Stock stock);

    public Stock update(Stock stock);

    public Stock getStock(long id);

    public List<Stock> findAll();

    public List<Stock> getAllFromStock(String category);

    public void delete(Stock stock);
}
