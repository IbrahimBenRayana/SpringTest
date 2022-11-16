package tn.test.spring.Services.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Entity.Stock;
import tn.test.spring.Repository.ProduitRepository;
import tn.test.spring.Services.GserviceImp;
import tn.test.spring.Services.Stock.StockServiceImp;

@Service
public class ProduitServiceImp extends GserviceImp<Produit,Integer> implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    StockServiceImp stockServiceImp;


    @Override
    public void assignProduitToStock(int idProduit, int idStock) {

        Produit produit = this.findById(idProduit);
        Stock stock = stockServiceImp.getStock(idStock);
        produit.setStock(stock);
        this.update(produit);

    }

    @Override
    public Produit findById(int id) {
        return produitRepository.findById(id).get();
    }

}