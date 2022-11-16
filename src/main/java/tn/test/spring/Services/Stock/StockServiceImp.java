package tn.test.spring.Services.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Repository.StockRepository;
import tn.test.spring.Services.GserviceImp;

import java.util.List;


@Service
public class StockServiceImp implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {
        Stock stock1 = stockRepository.findById(stock.getIdStock()).get();
        stockRepository.save(stock);

    }

    @Override
    public void deleteStock(Integer id) {
        Stock stock = stockRepository.findById(id).get();
        stockRepository.delete(stock);

    }

    @Override
    public Stock getStock(Integer id) {
        Stock stock = stockRepository.findById(id).get();
        return stock;
    }

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }




}

