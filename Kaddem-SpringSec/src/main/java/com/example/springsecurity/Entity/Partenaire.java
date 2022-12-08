package com.example.springsecurity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name ="Partenaire")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partenaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPartenaire")
    private Long idPartenaire; // Clé primaire
    private String nomPartenaire;
    private String localisation;
    private String email;
    private int numTelPar;
    private boolean mobilite;
    @Enumerated(EnumType.STRING)
    Support support ;

    @ManyToOne( fetch = FetchType.EAGER)
    Universite universites;
    @JsonIgnore
    @OneToMany( mappedBy="listpartenaire")
    private Set<Offre> offres;

}
