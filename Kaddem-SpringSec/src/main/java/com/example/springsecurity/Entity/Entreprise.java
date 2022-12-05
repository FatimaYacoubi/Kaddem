package com.example.springsecurity.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;
@Entity
@Table( name ="Entreprise")
@Getter
@Setter
public class Entreprise implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEntreprise")
    private Integer idEntreprise; // Clé primaire
    private String nomEntreprise;
    private String locEntreprise;
    @Column(nullable=true)
    private float latitude=1;
    @Column(nullable=true)
    private float longitude=1;
    private Integer nbPlaceRest;
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "EntrepriseContrat")
    private List<Contrat> ListContrats;


}