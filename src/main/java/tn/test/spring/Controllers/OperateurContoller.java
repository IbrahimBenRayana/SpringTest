package tn.test.spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.test.spring.Services.Operateur.OperateurServiceImp;

@RestController
@RequestMapping("/Operateur")
public class OperateurContoller {

    @Autowired
    OperateurServiceImp operateurServiceImp ;

    @PostMapping("/assign/{idFacture}/{idOperateur}")
    public void assignOperateurToFacture(@PathVariable(value = "idFacture") int idFacture ,@PathVariable(value = "idOperateur") int idOperateur ){
        operateurServiceImp.assignOperateurToFacture(idFacture,idOperateur);
    }



}
