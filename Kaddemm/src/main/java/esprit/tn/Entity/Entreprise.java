package esprit.tn.Entity;

import javax.persistence.*;
import java.io.Serializable;
import esprit.tn.Entity.Etudiant;
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
    private Integer nbPlaceRest;
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "EntrepriseContrat")
    private List<Contrat> ListContrats;


}