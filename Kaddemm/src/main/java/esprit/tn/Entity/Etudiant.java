package esprit.tn.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
@Entity
@Table( name ="Etudiant")
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private int idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;

@ManyToOne
private Departement dept;
@ManyToMany(cascade = {CascadeType.ALL})
@Column(nullable = true)
@JsonIgnore
private List<Equipe> EtdEquipe;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Contrat.class)
    @JoinColumn(name = "etudiantc_id_etudiant")
    @Column(nullable = true)
    @JsonIgnore
    private List<Contrat> contratsEtds;
// Constructeur et accesseurs (getters) et mutateurs (setters)
    public Etudiant() {
    }




    public void setContratsEtds(List<Contrat> contratsEtds) {
        this.contratsEtds = contratsEtds;
    }
}