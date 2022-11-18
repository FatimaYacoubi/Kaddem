package tn.esprit.spring.services;

import tn.esprit.spring.entity.Contrat;

import java.util.List;
import java.util.Optional;

public interface IContrat {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Long idContrat);

    void removeContrat(Long idContrat);

    Optional<Contrat> findContratById(Long id);

    public Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE);

}
