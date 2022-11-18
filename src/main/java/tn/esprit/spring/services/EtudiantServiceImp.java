package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.DepartmentRepository;
import tn.esprit.spring.repositories.EquipeRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EquipeRepository equipeRepository;

    public Long ajouter_etudiant(Etudiant e) {
        etudiantRepository.save(e);
        log.info("ajouter etudiant");

        return e.getIdEtudiant();
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    @Transactional
    public Etudiant updateEtudiant(Etudiant e) {
        List<Etudiant> etud = retrieveAllEtudiants();
        for(Etudiant r:etud){
            if(e.getIdEtudiant()==r.getIdEtudiant()){
                r.setContrat(e.getContrat());
                r.setDepartement(e.getDepartement());
                r.setOpt(e.getOpt());
                r.setEquipes(e.getEquipes());
                r.setDateF(e.getDateF());
                r.setNomE(e.getNomE());
                r.setPrenomE(e.getPrenomE());
                    return r;
            }
            }

        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        List<Etudiant> etud = retrieveAllEtudiants();
        for (Etudiant r : etud) {
            if (idEtudiant == r.getIdEtudiant()) {
                return r;
            }
        }
            return null;
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
            List<Etudiant> etudi = retrieveAllEtudiants();
            for(Etudiant r:etudi){
                if(idEtudiant==r.getIdEtudiant()){
                    etudiantRepository.delete(r);
                }
        }
    }




    public Optional< Etudiant > findEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    public void assignEdtudiantToDepartement( Long idEtudiant, Long departementId){
        Etudiant etudiant =etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = departmentRepository.findById(Long.valueOf(departementId)).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        return null;
    }


    @Transactional
    public  Etudiant addAndAssignEtudiantToEquipeandContrat(Etudiant e,Long idContrat, Long idEquipe)
    {
        Contrat c= contratRepository.findById(idContrat).orElse(null);
        Equipe eq= equipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        eq.getEtudiants().add(e);
        return e;
    }

    @Scheduled(fixedRate = 60000)
    public void fixedRateMethod(){
        System.out.println("Method with fixed Rate");
    }


}
