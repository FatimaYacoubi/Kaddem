package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContratServiceImp implements IContrat{

    @Autowired
    ContratRepository contratRepository;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return null;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        contratRepository.save(ce);
        return ce;
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {

        List<Contrat> etud = retrieveAllContrats();
        for (Contrat r : etud) {
            if (idContrat == r.getIdContrat()) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void removeContrat(Long idContrat) {
        List<Contrat> etudi = retrieveAllContrats();
        for(Contrat r:etudi){
            if(idContrat==r.getIdContrat()){
                contratRepository.delete(r);
            }
        }
    }

    @Override
    public Optional<Contrat> findContratById(Long id) {
        return contratRepository.findById(id);
    }
    /*
        public void Contrat affectContratToEtudiant(Contrat ce, String nomE,String prenomE){
            Etudiant etudiant =etudiantRepository.findAll(nomE,prenomE).orElse(null);
            etudiant.setDepartement(departement);
            etudiantRepository.save(etudiant);
        }
    */
    @Override
    public Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Contrat ce = contratRepository.findById(idContrat).get();
        if (etudiant != null) {
            int nombreContratActif = 0;
            for (Contrat contrat : etudiant.getContrat()) {
                if (contrat.getArchive() == true)
                    nombreContratActif++;
            }
            if (nombreContratActif < 5) {
                ce.setEtudiant(etudiant);
                ce.setArchive(true);
                updateContrat(ce);
            }
        }
        return ce;
    }



}
