package esprit.tn.Repository;

import esprit.tn.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
