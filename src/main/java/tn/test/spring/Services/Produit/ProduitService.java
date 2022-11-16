package tn.test.spring.Services.Produit;


import tn.test.spring.Entity.Produit;

public interface ProduitService {


    void assignProduitToStock(int idProduit, int idStock);

    Produit findById(int id);
}
