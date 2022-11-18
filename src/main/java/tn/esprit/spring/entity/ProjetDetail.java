package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Data
@Table( name ="ProjetDetail")
public class ProjetDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PD_ID")
    private Long idProjetDetail; // Identifiant projet detail (Clé primaire)

    @Column(name = "PD_DESCRIPTION")
    private String description;

    @Column(name = "PD_TECHNOLOGIE")
    private String technologie;

    @Column(name = "PD_COUT_PROVISOIRE")
    private Long cout_provisoire;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateLimite;

    @JsonIgnore
    @OneToOne(mappedBy = "projetDetail")
    private Projet projet;
}
