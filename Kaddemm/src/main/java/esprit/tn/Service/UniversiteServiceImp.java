package esprit.tn.Service;

import esprit.tn.Entity.Departement;
import esprit.tn.Entity.Etudiant;
import esprit.tn.Entity.Universite;
import esprit.tn.Repository.DepartementRepository;
import esprit.tn.Repository.EtudiantRepository;
import esprit.tn.Repository.UniversiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UniversiteServiceImp implements IUniversiteService{
    @Autowired
    UniversiteRepository UniversiteRepository;
    DepartementRepository departementRepository;

    EtudiantRepository etudiantRepository;

    public Integer ajouter_Universite(Universite e)
    {
        UniversiteRepository.save(e);
        log.info("ajouter Universiter");
        return (1);
    }
    public String delete_Universite(Integer id) {
        UniversiteRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    public List<Universite> Universite_List() {
        return UniversiteRepository.findAll();

    }

    public void update_Universite(Universite e) {
        UniversiteRepository.save(e);

    }

    public String deleteAllE() {
        UniversiteRepository.deleteAll();
        return "deleted";
    }

    public void assignUniversitetoDepartement(Integer idDepartement, Integer idUniversite) {
        Universite e = UniversiteRepository.findById(idUniversite).orElse(null);
        Departement u = departementRepository.findById(idDepartement).orElse(null);
        e.setDepU((List<Departement>) u);
        UniversiteRepository.save(e);
    }




}

