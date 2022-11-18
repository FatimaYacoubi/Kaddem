package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
