package com.example.springsecurity.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Professeur")
public class Professeur implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idProfesseur")
    private Long idProfesseur; // Clé primaire

    private String nomProf;
    private  String prenomProf;
    private  String emailProf;
    private Integer numTelProf;
    private  String module;
    private Date anneeAmb;
    private  Integer nbrheure;


    @Enumerated(EnumType.STRING)
    private Classe classe ;

//association avec departement
    @ManyToOne
    Departement departementsProf;

}
