package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;



@Getter
@Setter



@NoArgsConstructor
@Entity
public class DetailFacture {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailFacture;

    private int qteCommandee ;

    private float prixTotalDetail ;

    private int pourcentageRemise ;

    private float montantRemise ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Facture facture ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produit produit ;





}
