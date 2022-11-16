package tn.test.spring.Services.Stock;

import tn.test.spring.Entity.Stock;

import java.util.List;

public interface StockService {
    void addStock(Stock stock);
    void updateStock(Stock stock);
    void deleteStock(Integer id);
    Stock getStock(Integer id);

    List<Stock> retrieveAllStocks();

    String retrieveStatusStock() ;
}
