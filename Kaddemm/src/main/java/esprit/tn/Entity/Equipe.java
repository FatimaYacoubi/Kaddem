package esprit.tn.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name ="Equipe")
@Getter
@Setter
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

}
enum Niveau{
    JUNIOR,SENIOR,EXPERT
}