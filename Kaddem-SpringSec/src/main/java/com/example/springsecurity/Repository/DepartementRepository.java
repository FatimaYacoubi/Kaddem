package com.example.springsecurity.Repository;

import com.example.springsecurity.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
}
