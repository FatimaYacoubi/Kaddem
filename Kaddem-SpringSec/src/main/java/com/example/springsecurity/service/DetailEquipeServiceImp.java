package com.example.springsecurity.service;

import com.example.springsecurity.Entity.DetailEquipe;
import com.example.springsecurity.Repository.DetailEquipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
@Slf4j
public class DetailEquipeServiceImp implements IDetailEquipe {
    @Autowired
    DetailEquipeRepository detailEquipeRepository;

    public Long ajouterDetailEquipe(DetailEquipe d) {
        detailEquipeRepository.save(d);
        log.info("Ajouter DetailEquipe");
        return d.getIdDetailEquipe();
    }

    @Override
    public Iterable<DetailEquipe> retrieveAllDetailEquipe() {return detailEquipeRepository.findAll();}

    @Override
    public Optional< DetailEquipe > findDetailEquipeById(Long id) {
        return detailEquipeRepository.findById(id);
    }

    @Override
    public void deleteDetailEquipe(Long id) {
        detailEquipeRepository.deleteById(id);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {return detailEquipeRepository.save(d);}

    @Override
    public DetailEquipe retrieveDetailEquipe(Long idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).get();
    }

}
