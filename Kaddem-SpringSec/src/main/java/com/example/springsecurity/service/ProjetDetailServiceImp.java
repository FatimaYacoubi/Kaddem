package com.example.springsecurity.service;

import com.example.springsecurity.Entity.ProjetDetail;
import com.example.springsecurity.Repository.ProjetDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjetDetailServiceImp implements IProjetDetail{

    @Autowired
    ProjetDetailRepository projetDetailRepository;

    @Override
    public List<ProjetDetail> retrieveAllProjetDetails() {
        return projetDetailRepository.findAll();
    }

    @Override
    public Long ajouter_ProjetDetail(ProjetDetail e) {
        projetDetailRepository.save(e);
        return e.getIdProjetDetail();
    }

    @Override
    @Transactional
    public ProjetDetail updateProjetDetail(ProjetDetail e) {
        List<ProjetDetail> etud = retrieveAllProjetDetails();
        for(ProjetDetail r:etud){
            if(e.getIdProjetDetail()==r.getIdProjetDetail()){
                r.setDescription(e.getDescription());
                r.setCout_provisoire(e.getCout_provisoire());
                r.setTechnologie(e.getTechnologie());
                r.setDateDebut(e.getDateDebut());
                r.setDateLimite(e.getDateLimite());
                return r;
            }
        }

        return null;
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long idProjet) {
        return projetDetailRepository.findById(idProjet).get();
    }

    @Override
    public void removeProjetDetail(Long idProjet) {
      ProjetDetail pd =  retrieveProjetDetail(idProjet);
        projetDetailRepository.delete(pd);

    }


}