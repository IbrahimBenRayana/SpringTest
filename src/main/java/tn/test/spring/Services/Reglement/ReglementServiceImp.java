package tn.test.spring.Services.Reglement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Reglement;
import tn.test.spring.Repository.FactureRepository;
import tn.test.spring.Repository.ReglementRepository;
import tn.test.spring.Services.Facture.FactureServiceImp;
import tn.test.spring.Services.GserviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service

public class ReglementServiceImp extends GserviceImp<Reglement,Integer> implements ReglementService {


    @Autowired
    FactureServiceImp factureServiceImp ;
    @Autowired
    FactureRepository factureRepository ;
    @Autowired
    ReglementRepository reglementRepository ;

    @Override
    public List<Reglement> retrieveReglementByFacture(int idFacture) {
        Facture facture   = factureRepository.findByIdFacture(idFacture);
        return  reglementRepository.getReglementByFacture(facture);
    }

    @Override
    public Reglement addReglement(Reglement r, int idFacture) {
        List<Reglement> reglements = new ArrayList<>() ;
        reglements = this.retrieveReglementByFacture(idFacture);
        Facture facture = factureRepository.findByIdFacture(idFacture);
        float somme = 0f ;
        float rest = 0f ;
        float Mfacture  = facture.getMontantFacture() ;
        for (Reglement reglement : reglements) {
            somme += reglement.getMontantRestant();

        }
        rest = Mfacture - somme;
        if(r.getMontantRestant() <= rest ){
            r.setFacture(facture);
            this.add(r) ;
            return  r ;
        }else
            return  null ;

    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
      List<Facture> factures = factureServiceImp.retrieveAll() ;
      float totalReg = 0f ;
      float totalFac = 0f ;
      float percentage = 0f ;
        for(Facture facture : factures ){
            if(facture.getDateCreationFacture().after(startDate) && facture.getDateCreationFacture().before(endDate)&& !facture.isArchive()){
                totalFac += facture.getMontantFacture()  ;
                Set<Reglement> r = facture.getReglements() ;
              for (Reglement reg : r ){
                  totalReg += reg.getMontantRestant();
              }
            }
        }
      percentage = (totalReg/totalFac)*100 ;
        return percentage;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Reglement> reglements = this.retrieveAll();
        float chiffreAffaire = 0;

        for (Reglement reglement : reglements) {
            try {
                if (reglement.getDateReglement().after(startDate) && reglement.getDateReglement().before(endDate) && !reglement.getFacture().isArchive()) {
                    chiffreAffaire += reglement.getMontantRestant();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return chiffreAffaire;
    }


}
