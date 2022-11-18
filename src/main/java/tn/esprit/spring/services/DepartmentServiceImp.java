package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.DepartmentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImp implements IDepartment{

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departmentRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        departmentRepository.save(d);
        return d;
    }

    @Override
    @Transactional
    public Departement updateDepartement(Departement e) {

        List<Departement> etud = retrieveAllDepartements();
        for(Departement r:etud){
            if(e.getIdDepart()==r.getIdDepart()){
                r.setNomDepart(e.getNomDepart());
                r.setEtudiants(e.getEtudiants());
                return r;
            }
        }
        return null;
    }

    @Override
    public Departement retrieveDepartement(Long idDepart) {

        List<Departement> etud = retrieveAllDepartements();
        for (Departement r : etud) {
            if (idDepart == r.getIdDepart()) {
                return r;
            }
        }
        return null;

    }
}
