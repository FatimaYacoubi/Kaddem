package com.example.springsecurity.service;


import com.example.springsecurity.Entity.DetailEquipe;

import java.util.Optional;

public interface IDetailEquipe {

    public Long ajouterDetailEquipe(DetailEquipe detailEquipe);
    public Iterable<DetailEquipe> retrieveAllDetailEquipe();
    Optional< DetailEquipe > findDetailEquipeById(Long id);
    DetailEquipe retrieveDetailEquipe(Long idDetailEquipe);
    public void deleteDetailEquipe(Long id);
    DetailEquipe updateDetailEquipe(DetailEquipe d);

}
