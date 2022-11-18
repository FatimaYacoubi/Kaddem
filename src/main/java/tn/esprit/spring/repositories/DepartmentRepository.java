package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Departement;

public interface DepartmentRepository extends JpaRepository<Departement,Long> {
}
