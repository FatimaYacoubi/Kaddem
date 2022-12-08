package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Departement;
import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Repository.DepartementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class DepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;

    public Long ajouterDepartement(Departement d) {
        departementRepository.save(d);
        log.info("Ajouter Departement");
        return d.getIdDepart();
    }

    @Override
    public Iterable<Departement> retrieveAllDepartement() {return departementRepository.findAll();}

    @Override
    public  Departement findDepartementById(Long id) {

        return departementRepository.findById(id).get();
    }

    @Override
    public void deleteDepartement(long id) {
        departementRepository.deleteById(id);}

    @Override
    public Departement updateDepartement(Departement d) {return departementRepository.save(d);}

    public Departement retrieveDepartement(Long idDep) {
        return departementRepository.findById(idDep).get();
    }

    public List<Etudiant> getEtudiantsByDepar (Long idDepartement){
        return  retrieveDepartement(idDepartement).getEtudiantList();
    }

}
