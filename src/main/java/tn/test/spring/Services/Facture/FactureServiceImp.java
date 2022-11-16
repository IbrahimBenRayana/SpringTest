package tn.test.spring.Services.Facture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Fournisseur;
import tn.test.spring.Repository.FactureRepository;
import tn.test.spring.Repository.FournisseurRepository;
import tn.test.spring.Services.Fournisseur.FournisseurServiceImp;
import tn.test.spring.Services.GserviceImp;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FactureServiceImp extends GserviceImp<Facture,Integer> implements FactureService {
    @Autowired
    FactureRepository factureRepository ;
    @Autowired
    FournisseurRepository fournisseurRepository ;
    @Autowired
    FournisseurServiceImp fournisseurServiceImp ;

    @Override
    @Transactional
    public Facture addFacture(Facture f, int idFournisseur) {
        Fournisseur four = fournisseurRepository.findByIdFournisseur(idFournisseur) ;
        f.setFournisseur(four);
        this.add(f);

        return  f ;
    }


    @Override
    public List<Facture> getFacturesByFournisseur(int idFournisseur) {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseur(idFournisseur);
        return factureRepository.getFacturesByFournisseur(fournisseur) ;
    }
}
