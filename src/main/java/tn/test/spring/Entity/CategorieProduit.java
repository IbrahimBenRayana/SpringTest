package tn.test.spring.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class CategorieProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoriProduit;

    private String CodeProduit ;

    private String libelleCategorieProduit ;

    @OneToMany(mappedBy = "categorieProduit")
    private Set<Produit> produits;



}
