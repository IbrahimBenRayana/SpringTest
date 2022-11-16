package tn.test.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter


@NoArgsConstructor
@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFournisseur;

    private String codeFournisseur ;

    private String libelleFournisseur ;

    private CategorieFournisseur categorieFournisseur ;

    @ManyToMany(mappedBy = "fournisseurs")
    @JsonIgnore
    private Set<SecteurActivite> secteurActivites;

    @OneToOne
    private DetailFournisseur detailFournisseur;

    @OneToMany(mappedBy = "fournisseur")
    private Set<Facture> Factures;


}
