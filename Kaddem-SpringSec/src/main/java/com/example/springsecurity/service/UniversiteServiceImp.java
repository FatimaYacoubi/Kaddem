package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Departement;
import com.example.springsecurity.Entity.Universite;
import com.example.springsecurity.Repository.DepartementRepository;
import com.example.springsecurity.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService {


    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    public Long ajouterUniversite(Universite u) {
        universiteRepository.save(u);
        log.info("Ajouter Universite");
        return u.getIdUniversite();
    }

    @Override
    public Iterable<Universite> retrieveAllUniversite() {return universiteRepository.findAll();}

    @Override
    public Optional< Universite > findUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);}

    @Override
    public Universite updateUniversite(Universite u ) {

        return universiteRepository.save(u);

    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }
    public void assignUniversiteToDepartement(Long idUniversite, Long
            idDepartement){

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);

        universite.getDepartements().add(departement);
        universiteRepository.save(universite);


    }

    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite){

        return retrieveUniversite(idUniversite).getDepartements();
    }

    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate){
        return 0;
    }

    public Universite findUnivByEmail(String email) {

        return universiteRepository.findByEmail(email);

    }


}
