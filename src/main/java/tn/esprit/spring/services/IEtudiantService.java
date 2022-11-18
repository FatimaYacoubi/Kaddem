package tn.esprit.spring.services;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
public Long     ajouter_etudiant(Etudiant e);

    List<Etudiant> retrieveAllEtudiants();

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    Optional<Etudiant> findEtudiantById(Long id);
    public void assignEdtudiantToDepartement( Long idEtudiant, Long departementId);

    List<Etudiant> getEtudiantsByDepartement (Long idDepartement);

    public  Etudiant addAndAssignEtudiantToEquipeandContrat(Etudiant e, Long idContrat, Long idEquipe);

}
