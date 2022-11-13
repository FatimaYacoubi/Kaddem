package esprit.tn.Repository;

import esprit.tn.Entity.Departement;
import esprit.tn.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
