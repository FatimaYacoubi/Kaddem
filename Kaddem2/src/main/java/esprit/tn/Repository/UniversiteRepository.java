package esprit.tn.Repository;

import esprit.tn.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}
