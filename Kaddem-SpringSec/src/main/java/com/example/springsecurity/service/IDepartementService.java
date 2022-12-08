package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Departement;
import com.example.springsecurity.Entity.Etudiant;

import java.util.List;

public interface IDepartementService {

    public Long ajouterDepartement(Departement d);
    public Iterable<Departement> retrieveAllDepartement();
    Departement  findDepartementById(Long id);

    public void deleteDepartement(long id);
    Departement updateDepartement(Departement d);
    public Departement retrieveDepartement(Long idDep);
    public List<Etudiant> getEtudiantsByDepar (Long idDepartement);
}
