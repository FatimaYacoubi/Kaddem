package esprit.tn.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name ="Contrat")
@Getter
@Setter
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)

    private Date datefinContrat;
    private Specialite specialite;
    private Boolean archive;
    private String descriptionContrat;
    @ManyToOne(cascade=CascadeType.ALL)
    private Etudiant etudiantC;
    @JsonIgnore

    @Column(nullable = true)
    private String nomEC;
@JsonIgnore
    public String getNomEC() {
        return nomEC=etudiantC.getNomE();
    }
    @JsonIgnore
    public void setNomEC(String nomEC) {
        this.nomEC = nomEC;
    }
    @ManyToOne

    private Entreprise EntrepriseContrat;
    public Contrat() {
    }
    private int montantContrat;


}

