package com.example.springsecurity.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table( name ="Equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @JsonIgnore
    @ManyToMany
    private Set<Etudiant> etudiants;
    @JsonBackReference

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DetailEquipe detailEquipe;
}
