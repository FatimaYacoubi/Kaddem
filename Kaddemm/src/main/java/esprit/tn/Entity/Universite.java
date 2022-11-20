package esprit.tn.Entity;

import esprit.tn.Service.IDepartementService;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table( name ="Universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private int idUniv;
    private String nomUniv;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Departement> depU;


}
