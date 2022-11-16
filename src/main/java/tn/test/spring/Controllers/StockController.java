package tn.test.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Services.Stock.StockServiceImp;

import java.util.List;

@RestController
@RequestMapping("/stock")

public class StockController {


        @Autowired
        StockServiceImp stockServiceImp;

        @GetMapping
        public List<Stock> retrieveAll() {
            return stockServiceImp.retrieveAllStocks();
        }

        @PostMapping
        public void addStock(@RequestBody Stock s) {
            stockServiceImp.addStock(s);
        }

        @GetMapping("/{id}")
        public Stock retrieveStock(@PathVariable int id) {
            return stockServiceImp.getStock(id);
        }

        @DeleteMapping("/{id}")
        public void deleteStock(@PathVariable int id) {
            stockServiceImp.deleteStock(id);
        }

        @PutMapping
        public void updateStock(@RequestBody Stock s) {
            stockServiceImp.updateStock(s);
        }
    }

