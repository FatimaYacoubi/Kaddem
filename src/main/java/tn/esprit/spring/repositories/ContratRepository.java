package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
