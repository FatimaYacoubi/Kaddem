package tn.esprit.spring.services;

import tn.esprit.spring.entity.Equipe;

import java.util.List;
import java.util.Optional;

public interface IEquipe {

    List<Equipe> retrieveAllEquipes();


    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Optional<Equipe> retrieveEquipe(Long id);
}
