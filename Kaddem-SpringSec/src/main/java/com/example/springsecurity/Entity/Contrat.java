package com.example.springsecurity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name ="Contrat")
@Getter
@Setter
@AllArgsConstructor
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

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.ALL },fetch = FetchType.EAGER)
    private Etudiant etudiantC;
    @JsonIgnore

    @Column(nullable = true)
    private String nomEC;

    @ManyToOne(cascade = {CascadeType.MERGE },fetch = FetchType.LAZY)
    private Entreprise  EntrepriseContrat;
    public Contrat() {
    }
    private int montantContrat;
    public double getComissionContrat()
    { double comission = montantContrat*0.4;
        return(comission);

    }

}

