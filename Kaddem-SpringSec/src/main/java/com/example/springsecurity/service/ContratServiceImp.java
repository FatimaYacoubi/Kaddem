package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Repository.ContratRepository;
import com.example.springsecurity.Repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //long x=co.getEtudiantC().getIdEtudiant();
        co.setEtudiantC(co.getEtudiantC());
        //Optional<Etudiant> e=etudiantRepository.findById(x);
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
        c.setEtudiantC(contrat.getEtudiantC());
return contratRepository.save(c);
    }

    @Override
    public String deleteAllC() {
        contratRepository.deleteAll();
        return "deleted";    }

    public Contrat addContrat(Contrat contrat)
    {
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
}
