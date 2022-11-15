package com.example.springsecurity.Repository;


import com.example.springsecurity.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository <Contrat,Long>{
    List<Contrat> findByDateDebutContratAndDateFinContrat(Date start,Date end);

    @Query(value = "Select C FROM Contrat C")
    List<Contrat> findcontrat( );

    List<Contrat> findByDateDebutContratBetween(Date start,Date end);

}
