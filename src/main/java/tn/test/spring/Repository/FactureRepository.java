package tn.test.spring.Repository;

import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Fournisseur;

import java.util.List;

public interface FactureRepository extends GRepository<Facture> {
    Facture findByIdFacture (int id) ;
    List<Facture> getFacturesByFournisseur(Fournisseur fournisseur);

}

