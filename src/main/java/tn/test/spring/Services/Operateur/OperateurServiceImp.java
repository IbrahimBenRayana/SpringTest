package tn.test.spring.Services.Operateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Operateur;
import tn.test.spring.Repository.FactureRepository;
import tn.test.spring.Repository.OperateurRepository;
import tn.test.spring.Services.GserviceImp;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
@Service
public class OperateurServiceImp extends GserviceImp<Operateur,Integer> implements OperateurService {

    @Autowired
    OperateurRepository operateurRepository ;
    @Autowired
    FactureRepository factureRepository ;


    @Override
    @Transactional
    public void assignOperateurToFacture(int idOperateur, int idFacture) {
      Operateur op = operateurRepository.findByIdOperateur(idOperateur) ;
      Facture fac = factureRepository.findByIdFacture(idFacture) ;

        Set<Facture> factures = new HashSet<>()   ;
        factures.add(fac) ;
        System.out.println(factures);
        System.out.println(fac);
        System.out.println(op);
        op.setFactures(factures);


    }
}
