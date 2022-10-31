package esprit.tn.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import lombok.*;
@Entity
@Table( name ="Etudiant")
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;

@ManyToOne
private Departement dept;
@ManyToMany(cascade = {CascadeType.ALL})
private List<Equipe> EtdEquipe;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiantC")
    private List<Contrat> contratsEtds;
// Constructeur et accesseurs (getters) et mutateurs (setters)
    public Etudiant() {
    }


}