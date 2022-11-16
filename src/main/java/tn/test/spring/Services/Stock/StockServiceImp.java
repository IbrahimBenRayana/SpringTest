package tn.test.spring.Services.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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


    @Override
    @Scheduled(cron = " 0 00 22 ? * *" )
    public String retrieveStatusStock()  {
        String message  =" " ;
        List<Stock> stocks  = this.retrieveAllStocks() ;
        for(Stock stock :stocks) {
            if (stock.getQte() < stock.getQteMin()) {
                message = " la quantité disponible\n" +
                        "est inférieure à la quantité min toléré. \n"
                        + "pour le stock " + stock.getIdStock() + ":" + stock.getLibelleStock();
                System.out.println(message);
            }
        }

        return message ;
    }


}

