
package tn.esprit.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.*;

@Entity

@Data
@Getter
@Setter
@Table( name ="Etudiant")
        public class Etudiant implements Serializable {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column(name="idEtudiant")
        private Long idEtudiant; // Clé primaire
        private String prenomE;
        private String nomE;


    @GeneratedValue(strategy =GenerationType.AUTO )

    public Option getOpt()
    {
        return opt;
    }
    @Enumerated(EnumType.STRING)
        private Option opt;
    @Temporal(TemporalType.DATE)
    private Date dateF;


    @OneToMany(mappedBy = "etudiant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Contrat> contrat;


    @ManyToOne
    private Departement departement;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;


// Constructeur et accesseurs (getters) et mutateurs (setters)


    public Etudiant() {
    }
}
