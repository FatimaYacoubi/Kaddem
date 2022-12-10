package tn.esprit.spring.services;

import tn.esprit.spring.entity.ProjetDetail;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IProjetDetail {

    List<ProjetDetail> retrieveAllProjetDetails();

    public Long     ajouter_ProjetDetail(ProjetDetail e);

    ProjetDetail updateProjetDetail(ProjetDetail e);

    ProjetDetail retrieveProjetDetail(Long idProjet);

    void removeProjetDetail(Long idProjet);



    List<ProjetDetail> retrieveAllProjetDetailsbytechnologieanddescription(String techno,String desc);


    List<ProjetDetail> findByDateDebutBetween(Date datedeb,Date datefin);


}
