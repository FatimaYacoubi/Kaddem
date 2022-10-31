package esprit.tn.Entity;

import javax.persistence.*;

@Entity
@Table( name ="DetailEquipe")
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DetailEquipe")
    private int idDetailEquipe;
    private int salle;
    private String thematique;
@OneToOne(cascade = {CascadeType.ALL},mappedBy = "EquipeDetail")
    private Equipe DEquipe;
}
