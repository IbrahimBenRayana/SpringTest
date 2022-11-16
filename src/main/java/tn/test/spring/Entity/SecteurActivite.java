package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SecteurActivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSectorActivite;

    private String codeSectorActivite ;

    private String libelleSectorActivite ;

    @ManyToMany
    private Set<Fournisseur> fournisseurs;

}
