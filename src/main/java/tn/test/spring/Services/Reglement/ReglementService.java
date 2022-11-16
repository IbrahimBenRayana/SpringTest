package tn.test.spring.Services.Reglement;

import tn.test.spring.Entity.Reglement;

import java.util.Date;
import java.util.List;

public interface ReglementService {

    public List<Reglement> retrieveReglementByFacture(int idFacture);
    Reglement addReglement(Reglement r, int idFacture);

    float pourcentageRecouvrement(Date startDate, Date endDate);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) ;

}
