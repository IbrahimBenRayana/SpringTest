package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import tn.test.spring.Entity.Facture;

@Getter
@Setter


@NoArgsConstructor
@Entity
public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReglement;


    private String montantPaye ;

   private String  montantRestant ;

   private Boolean payee ;

    @Temporal(TemporalType.DATE)
   private Date dateReglement;

    @ManyToOne(cascade = CascadeType.ALL)
    private Facture facture;











}
