package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.entity.ProjetDetail;
import tn.esprit.spring.repositories.ProjetDetailRepository;
import tn.esprit.spring.repositories.ProjetRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProjetServiceImp implements IProjet {

    private ProjetRepository projetRepository;

    private ProjetDetailRepository projetDetailRepository;


    @Override
    public Long ajouter_projet(Projet p,Long idProjetdetail) {
        ProjetDetail prodet = projetDetailRepository.findById(idProjetdetail).get();
        p.setProjetDetail(prodet);
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
    public Projet updateProjet(Projet p , Long idProjetdetail) {
        List<Projet> proj = retrieveAllProjets();
        ProjetDetail prodet = projetDetailRepository.findById(idProjetdetail).get();
        for(Projet r:proj){
            if(r.getIdProjet()==p.getIdProjet()){
                r.setSujet(p.getSujet());
                r.setEtat(p.getEtat());
                r.setProjetDetail(prodet);
                projetRepository.save(r);
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
