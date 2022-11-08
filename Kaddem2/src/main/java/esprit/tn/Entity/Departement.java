package esprit.tn.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name ="Departement")
@Getter
@Setter
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")

    private int idDepart;
    private String nomDepart;
@OneToMany(mappedBy = "dept")
    private List<Etudiant> etds;
}
