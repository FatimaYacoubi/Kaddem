package com.example.springsecurity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name ="Contrat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)

    private Date datefinContrat;
    private Specialite specialite;
    private Boolean archive;
    private String descriptionContrat;
    @ManyToOne(cascade = {CascadeType.MERGE },fetch = FetchType.EAGER)
    private Etudiant etudiantC;
    @ManyToOne(cascade = {CascadeType.MERGE },fetch = FetchType.LAZY)
    private Entreprise  EntrepriseContrat;
    private int montantContrat;
    public double getComissionContrat()
    { double comission = montantContrat*0.4;
        return(comission);

    }

}

