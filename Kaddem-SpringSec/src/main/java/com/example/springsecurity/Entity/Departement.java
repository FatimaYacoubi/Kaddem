package com.example.springsecurity.Entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Departement")
public class Departement implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")
    private Long idDepart; // Clé primaire
    private String nomDepart;
/*
    @JsonIgnore
    @OneToMany( )
    private Set<Etudiant> etudiants;

    */

    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    List<Etudiant> etudiantList;

    @OneToMany( mappedBy="departementsProf",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Professeur>   professeurs;


}
