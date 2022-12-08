package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjet {

    public Long     ajouter_projet(Projet p, Long idProjetdetail);

    List<Projet> retrieveAllProjets();

    Projet updateProjet(Projet p);

    Projet retrieveProjet(Long idProjet);

    void removeProjet(Long idProjet);

    void affectprojetdetailtoprojet(Projet pro, Long idProjetdetail);
}
