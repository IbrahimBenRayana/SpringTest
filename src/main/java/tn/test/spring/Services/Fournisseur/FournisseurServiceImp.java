package tn.test.spring.Services.Fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.test.spring.Entity.Facture;
import tn.test.spring.Entity.Fournisseur;
import tn.test.spring.Repository.FactureRepository;
import tn.test.spring.Repository.FournisseurRepository;
import tn.test.spring.Services.GserviceImp;

import java.util.List;

@Service
public class FournisseurServiceImp extends GserviceImp<Fournisseur,Integer> implements FournisseurService {


    @Autowired
    FournisseurRepository fournisseurRepository ;



}
