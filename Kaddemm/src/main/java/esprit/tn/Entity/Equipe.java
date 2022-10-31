package esprit.tn.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name ="Equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;
@ManyToMany(cascade = {CascadeType.ALL},mappedBy = "EtdEquipe")
private List<Etudiant> EquipeEtds;
  @OneToOne(cascade = {CascadeType.ALL})
  private DetailEquipe EquipeDetail;
    public Equipe() {
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
enum Niveau{
    JUNIOR,SENIOR,EXPERT
}