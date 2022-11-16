package tn.test.spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Services.Facture.FactureServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Facture")
public class FactureController {

    @Autowired
    FactureServiceImp factureServiceImp ;

    @PostMapping("/addAndAssign/{idFour}")
    public Facture addFacture( @RequestBody Facture facture,@PathVariable(value = "idFour") int idFour ) {

       Facture f =  factureServiceImp.addFacture(facture,idFour) ;
       return f ;
    }


    @GetMapping("/{idFournisseur}")
    public List<Facture> getFacturesByFournisseur(@PathVariable(value = "idFournisseur") int idFournisseur){
        return  factureServiceImp.getFacturesByFournisseur(idFournisseur);
    }

}
