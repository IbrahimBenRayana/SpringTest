package tn.test.spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.test.spring.Entity.Produit;
import tn.test.spring.Services.Produit.ProduitService;
import tn.test.spring.Services.Produit.ProduitServiceImp;

@RestController
@RequestMapping("/Produit")
public class ProduitController {

    @Autowired
    ProduitServiceImp produitServiceImp;;

   @PostMapping
    public void addProduit(@RequestBody Produit produit){
        produitServiceImp.add(produit);
    }

    @PostMapping("/assign")
    public void assignProduitToStock(@RequestBody Produit produit){
        produitServiceImp.assignProduitToStock(produit.getIdProduit(),produit.getStock().getIdStock());
    }

}
