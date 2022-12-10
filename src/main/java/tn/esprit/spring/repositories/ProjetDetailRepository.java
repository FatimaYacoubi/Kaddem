package tn.esprit.spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.ProjetDetail;

import java.util.Date;
import java.util.List;
@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail,Long> {
    List<ProjetDetail> findByTechnologieContainsOrDescriptionContains(String tech, String disc);


    List<ProjetDetail> findByDateDebutBetween(Date datedeb,Date datefin);

}
