package tn.esprit.spring.services;

import tn.esprit.spring.entity.Departement;

import java.util.List;

public interface IDepartment {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement e);

    Departement retrieveDepartement (Long idDepart);
}
