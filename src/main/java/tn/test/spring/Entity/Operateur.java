package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Operateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOperateur;

    private String nom ;

    private String prenom ;

    private String password ;

    @OneToMany
    private Set<Facture> factures;
}
