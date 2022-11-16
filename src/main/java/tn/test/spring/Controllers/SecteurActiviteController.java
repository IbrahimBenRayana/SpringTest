package tn.test.spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.test.spring.Services.SecteurActivite.SecteurActiviteService;
import tn.test.spring.Services.SecteurActivite.SecteurActiviteServiceImp;

@RestController
@RequestMapping("/SecteurActivite")
public class SecteurActiviteController {

    @Autowired
    SecteurActiviteServiceImp secteurActiviteServiceImp ;

    @GetMapping("/assigneAcF/{idFour}/{idSect}")
    public void assignSecteurActiviteToFournisseur(@PathVariable(value = "idFour") int idFour , @PathVariable(value = "idSect") int idSec){
        secteurActiviteServiceImp.assignSecteurActiviteToFournisseur(idFour,idSec);
    }
}
