package esprit.tn.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name ="DetailEquipe")
@Getter
@Setter
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
