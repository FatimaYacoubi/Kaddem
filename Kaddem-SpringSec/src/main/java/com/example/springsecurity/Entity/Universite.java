package com.example.springsecurity.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name ="Universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private Long idUniversite; // Clé primaire

    private String nomUniv;
    public String email;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;

    @OneToMany( mappedBy="universites",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Partenaire> partenaires;

}
