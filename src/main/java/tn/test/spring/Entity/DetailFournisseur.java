package tn.test.spring.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter


@NoArgsConstructor
@Entity
public class DetailFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailFournisseur;

    @Temporal(TemporalType.DATE)
    private Date dateDebutCollaboration;

    private String adresse ;

    private String matricule ;

    @OneToOne
    private Fournisseur fournisseur;
}
