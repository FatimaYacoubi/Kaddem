package esprit.tn.Service;

import esprit.tn.Entity.Etudiant;
import esprit.tn.Repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class EtudiantServiceImp implements IEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    public Long ajouter_etudiant(Etudiant e)
    {
        etudiantRepository.save(e);
        log.info("ajouter Etudiantr");
        return e.getIdEtudiant();
    }
    public String delete_etudiant(Long id) {
        etudiantRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    public List<Etudiant> etudiant_List() {
        return etudiantRepository.findAll();

    }

    public void update_Etudiant(Etudiant e) {
        etudiantRepository.save(e);

    }

    public String deleteAllE() {
        etudiantRepository.deleteAll();
        return "deleted";
    }

}
