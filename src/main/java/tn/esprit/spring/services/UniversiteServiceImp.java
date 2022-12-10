package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.DepartmentRepository;
import tn.esprit.spring.repositories.UniversiteRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UniversiteServiceImp implements IUniversite {

    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        universiteRepository.save(u);
        return u;
    }

    @Override
    @Transactional
    public Universite updateUniversite(Universite e) {
        List<Universite> etud = retrieveAllUniversites();
        for (Universite r : etud) {
            if (e.getIdUniv() == r.getIdUniv()) {
                r.setDepartment(e.getDepartment());
                r.setNomUniv(e.getNomUniv());

                return r;
            }
        }

        return null;
    }

    @Override
    public Optional<Universite> findUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Universite universite =universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departmentRepository.findById(idDepartement).orElse(null);
        universite.setDepartment((Set<Departement>) departement);
        universiteRepository.save(universite);
    }


}
