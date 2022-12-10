package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Data
@Setter
@Getter
@Table( name ="Projet")
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJET_ID")
    private Long idProjet; // Identifiant projet (Clé primaire)

    @Column(name = "PROJET_SUJET")
    private String sujet;

    @Column(name = "PROJET_ETAT")
    private String etat;




    @OneToOne(cascade = CascadeType.ALL )
    private ProjetDetail projetDetail;

}
