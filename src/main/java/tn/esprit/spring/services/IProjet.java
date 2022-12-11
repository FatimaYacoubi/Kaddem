package tn.esprit.spring.services;

import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.entity.ProjetDetail;

import java.util.List;
import java.util.Optional;

public interface IProjet {

    public Long ajouter_projet(Projet p,Long idProjetdetail);

    List<Projet> retrieveAllProjets();

    Projet updateProjet(Projet p,Long idProjetdetail);

    Projet retrieveProjet(Long idProjet);

    void removeProjet(Long idProjet);


}
