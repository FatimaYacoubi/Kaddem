package tn.esprit.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // Clé primaire

    private String nomEquipe ;

    public Niveau getNiveau()
    {
        return niveau;
    }
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DetailEquipe detailequipe;

}
