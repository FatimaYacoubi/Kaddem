package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Projet;
import com.example.springsecurity.Entity.ProjetDetail;
import com.example.springsecurity.Repository.ProjetDetailRepository;
import com.example.springsecurity.Repository.ProjetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjetServiceImp implements IProjet {

    @Autowired
    ProjetRepository projetRepository;

    @Autowired
    ProjetDetailRepository projetDetailRepository;


    @Override
    public Long ajouter_projet(Projet p, Long idProjetdetail) {
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
    public Projet updateProjet(Projet p) {
        List<Projet> proj = retrieveAllProjets();
        for(Projet r:proj){
            if(r.getIdProjet()==p.getIdProjet()){
                r.setSujet(p.getSujet());
                r.setEtat(p.getEtat());
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


    @Override
    public void affectprojetdetailtoprojet(Projet pro,Long  idProjetdetail) {
        ProjetDetail prodet = projetDetailRepository.findById(idProjetdetail).get();
        pro.setProjetDetail(prodet);
        projetRepository.save(pro);

    }

}
