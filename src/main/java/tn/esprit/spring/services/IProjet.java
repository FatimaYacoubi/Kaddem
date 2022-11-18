package tn.esprit.spring.services;

import tn.esprit.spring.entity.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjet {

    public Long     ajouter_projet(Projet p);

    List<Projet> retrieveAllProjets();

    Projet updateProjet(Projet p);

    Projet retrieveProjet(Long idProjet);

    void removeProjet(Long idProjet);
}
