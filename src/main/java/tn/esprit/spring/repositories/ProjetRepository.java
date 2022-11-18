package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet,Long> {
}
