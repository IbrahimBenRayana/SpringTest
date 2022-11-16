package tn.test.spring.Repository;

import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Reglement;

import java.util.List;

public interface ReglementRepository extends GRepository<Reglement> {

    Reglement findByIdReglement (int id) ;
    List<Reglement> getReglementByFacture(Facture facture) ;
}

