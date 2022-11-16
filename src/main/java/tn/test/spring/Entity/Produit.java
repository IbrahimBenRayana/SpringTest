package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter


@NoArgsConstructor
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

   private String codeProduit ;

   private String libelleProduit ;

   private float prix  ;

    @Temporal(TemporalType.DATE)
    private Date dateCreation  ;

    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification ;


    @ManyToOne
    private CategorieProduit categorieProduit;

    @OneToMany(mappedBy = "produit")
    private Set<DetailFacture> detailFactures;

    @ManyToOne
    private Stock stock;


}
