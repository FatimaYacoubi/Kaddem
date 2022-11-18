package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
