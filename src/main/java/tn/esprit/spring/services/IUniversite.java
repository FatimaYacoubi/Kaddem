package tn.esprit.spring.services;

import tn.esprit.spring.entity.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversite {

    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite e);


    Optional<Universite> findUniversiteById(Long id);

    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
}
