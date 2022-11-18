package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.repositories.ProjetRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjetServiceImp implements IProjet {

    @Autowired
    ProjetRepository projetRepository;
    @Override
    public Long ajouter_projet(Projet p) {

        projetRepository.save(p);
        log.info("ajouter Projet");
        return p.getIdProjet();
    }

    @Override
    public List<Projet> retrieveAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    @Transactional
    public Projet updateProjet(Projet p) {
        List<Projet> proj = retrieveAllProjets();
        for(Projet r:proj){
            if(p.getIdProjet()==p.getIdProjet()){
                r.setProjetDetail(p.getProjetDetail());
                r.setSujet(p.getSujet());
                r.setEtat(p.getEtat());
                return r;
            }
        }
        return null;
    }

    @Override
    public Projet retrieveProjet(Long idProjet) {
        return projetRepository.findById(idProjet).get();
    }

    @Override
    public void removeProjet(Long idProjet) {
      Projet p = retrieveProjet(idProjet);
        projetRepository.delete(p);
    }


}
