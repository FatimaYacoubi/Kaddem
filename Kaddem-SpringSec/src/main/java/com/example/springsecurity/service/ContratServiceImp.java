package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Repository.ContratRepository;
import com.example.springsecurity.Repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContratServiceImp implements IContratService {


    @Autowired
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public void ajouter_contrat(Contrat co) {
        co.setIdContrat(co.getIdContrat());
        co.setDateDebutContrat(co.getDateDebutContrat());
        co.setDatefinContrat(co.getDatefinContrat());
        co.setDescriptionContrat(co.getDescriptionContrat());
        co.setMontantContrat(co.getMontantContrat());
        co.setArchive(co.getArchive());
        co.setSpecialite(co.getSpecialite());
        co.setEtudiantC(co.getEtudiantC());
       // long x=co.getEtudiantC().getIdEtudiant();
       // Optional<Etudiant> e=etudiantRepository.findById(x);
        //co.setEtudiantC(e.get());
        contratRepository.save(co);
     }

    @Override
    public String delete_contrat(Integer id) {
        contratRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    @Override
    public List<Contrat> contrat_List() {
        return contratRepository.findAll();
    }

    public Contrat update_contrat(Contrat contrat) {
        int x = contrat.getIdContrat();
        Contrat c = contratRepository.findById(x).get();
        c.setDateDebutContrat(contrat.getDateDebutContrat());
        c.setDatefinContrat(contrat.getDatefinContrat());
        c.setDescriptionContrat(contrat.getDescriptionContrat());
        c.setMontantContrat(contrat.getMontantContrat());
        c.setArchive(contrat.getArchive());
        c.setSpecialite(contrat.getSpecialite());
c.getEtudiantC().setNomE(c.getEtudiantC().getNomE());
        c.getEtudiantC().setPrenomE(c.getEtudiantC().getPrenomE());
        c.getEtudiantC().setIdEtudiant(c.getEtudiantC().getIdEtudiant());


return contratRepository.save(c);
    }

    @Override
    public String deleteAllC() {
        contratRepository.deleteAll();
        return "deleted";    }

    public Contrat addContrat(Contrat contrat)
    {   long idEt= contrat.getEtudiantC().getIdEtudiant();
        Etudiant etudiantentity = etudiantRepository.findById(idEt).get();
        contrat.setEtudiantC(etudiantentity);
       return contratRepository.save(contrat);

    }

   // @Transactional

   // Contrat affectContratToEtudiant (Integer idContrat, String nomE,String prenomE)
    //{ Contrat c = contratRepository.findBy(idContrat).get();
      //  Etudiant e = etudiantRepository .findBynomEandprenomE(nomE,prenomE).get();
       // if(e.getContratsEtds().size()>5)
        //{//

       // }

       // return null;
    //}
       public void showall() {
       }
       public List <Contrat>getPercentageGroupBySpecialite()
       {
           return contratRepository.getPercentageGroupBySpecialite();
       }
       @Override
    public List <Contrat>getcontratbyidetudiant(Long id)
    {
        return contratRepository.findContratByEtudiantCIdEtudiant(id);
    }
    @Override
    public Etudiant AssignEtudiantToContrat (Long idEtudiant, int idContrat){
        Etudiant etudiantentity =etudiantRepository.findById(idEtudiant).get();
        Contrat contratentity = contratRepository.findById(idContrat).get();
        contratentity.setEtudiantC(etudiantentity);
        contratRepository.save(contratentity);
        return (etudiantentity);
    }

}
