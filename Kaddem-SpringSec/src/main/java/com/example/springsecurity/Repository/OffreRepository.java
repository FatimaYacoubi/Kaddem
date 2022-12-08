package com.example.springsecurity.Repository;
import com.example.springsecurity.Entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OffreRepository extends JpaRepository<Offre, Long> {



}
