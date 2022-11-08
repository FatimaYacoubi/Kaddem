package esprit.tn.Entity;

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
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;
    @ManyToOne
    private Etudiant etudiantC;
    public Contrat() {
    }
    int montantContrat;
}
enum Specialite {
    IA,RESEAUX,CLOUD,SECURITE;
}
