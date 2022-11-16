package tn.test.spring.Services.SecteurActivite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Fournisseur;
import tn.test.spring.Entity.SecteurActivite;
import tn.test.spring.Repository.FournisseurRepository;
import tn.test.spring.Repository.SecteurActiviteRepository;
import tn.test.spring.Services.Fournisseur.FournisseurServiceImp;
import tn.test.spring.Services.GserviceImp;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Service
public class SecteurActiviteServiceImp extends GserviceImp<SecteurActivite,Integer> implements SecteurActiviteService {


    @Autowired
    FournisseurRepository fournisseurRepository ;
    @Autowired
    SecteurActiviteRepository secteurActiviteRepository ;

    @Override
    @Transactional
    public void assignSecteurActiviteToFournisseur(int fournisseurId, int secteurActiviteId) {
        Fournisseur fournisseur = fournisseurRepository.findByIdFournisseur(fournisseurId);
        SecteurActivite secteurActivite = secteurActiviteRepository.findByIdSectorActivite(secteurActiviteId);
        Set<Fournisseur> fournisseurs  = new HashSet<>() ;
        fournisseurs.add(fournisseur);

        secteurActivite.setFournisseurs(fournisseurs);
        secteurActivite.getFournisseurs().add(fournisseur);

    }
}
