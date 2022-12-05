package com.example.springsecurity.Repository;


import com.example.springsecurity.Entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

    List<Entreprise> findEntrepriseByNomEntreprise(String nomEntreprise);
}
