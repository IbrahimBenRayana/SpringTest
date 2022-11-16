package tn.test.spring.Services.Facture;

import tn.test.spring.Entity.Facture;

import java.util.List;

public interface FactureService {
    Facture addFacture(Facture f, int idFournisseur);
    List<Facture> getFacturesByFournisseur(int idFournisseur);
}
