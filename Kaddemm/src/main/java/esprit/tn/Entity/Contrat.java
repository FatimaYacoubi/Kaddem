package esprit.tn.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name ="Contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private int idContrat;
    private Date dateDebutContrat;
    private Date datefinContrat;
    private Specialite specialite;
    private Boolean archive;
    @ManyToOne
    private Etudiant etudiantC;
    public Contrat() {
    }
    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Date getDatefinContrat() {
        return datefinContrat;
    }

    public void setDatefinContrat(Date datefinContrat) {
        this.datefinContrat = datefinContrat;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public int getMontantContrat() {
        return montantContrat;
    }

    public void setMontantContrat(int montantContrat) {
        this.montantContrat = montantContrat;
    }

    int montantContrat;
}
enum Specialite {
    IA,RESEAUX,CLOUD,SECURITE;
}
