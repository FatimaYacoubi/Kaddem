package com.example.springsecurity.Repository;

import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat getContratByDescriptionContrat(String descriptionContrat);
    Contrat findByEtudiantC(String nomE);
    @Query(value="Select *,COUNT(*)/100 FROM contrat group by specialite",nativeQuery = true)
    public List<Contrat> getPercentageGroupBySpecialite();

    List<Contrat> findContratBySpecialite(Specialite specialite);
}
