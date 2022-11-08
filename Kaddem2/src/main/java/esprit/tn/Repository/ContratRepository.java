package esprit.tn.Repository;

import esprit.tn.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}
