package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStock;

    private int qte ;

    private int qteMin ;

    private String libelleStock ;

    @OneToMany(mappedBy = "stock")
    private Set<Produit> produits;


}
