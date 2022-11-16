package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;



@Getter
@Setter


@NoArgsConstructor
@Entity
public class Facture {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacture;

    private float montantRemise ;

    private float montantFacture ;

    @Temporal(TemporalType.DATE)
    private Date dateCreationFacture;

    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification ;

    private boolean archive ;

    @OneToMany(mappedBy = "facture")
    private Set<Reglement>  reglements ;

    @OneToMany
    private Set<Facture> factures;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fournisseur fournisseur;



}
