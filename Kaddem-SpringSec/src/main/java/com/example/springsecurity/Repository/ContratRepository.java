package com.example.springsecurity.Repository;

import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Entity.Specialite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat getContratByDescriptionContrat(String descriptionContrat);
    Contrat findByEtudiantC(String nomE);
    @Query(value="Select *,COUNT(*)/100 FROM contrat group by specialite",nativeQuery = true)
    public List<Contrat> getPercentageGroupBySpecialite();

    List<Contrat> findContratBySpecialite(Specialite specialite);

    List<Contrat> findContratByEtudiantCIdEtudiant(Long id);
    Page<Contrat> findContratByDescriptionContratContaining(String DescriptionContrat, Pageable pageable);
}
