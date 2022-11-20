package esprit.tn.Repository;

import esprit.tn.Entity.Contrat;
import esprit.tn.Entity.Etudiant;
import esprit.tn.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat getContratByDescriptionContrat(String descriptionContrat);
}
