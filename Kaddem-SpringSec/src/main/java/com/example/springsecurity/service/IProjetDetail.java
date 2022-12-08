package com.example.springsecurity.service;

import com.example.springsecurity.Entity.ProjetDetail;

import java.util.List;
import java.util.Optional;

public interface IProjetDetail {

    List<ProjetDetail> retrieveAllProjetDetails();

    public Long     ajouter_ProjetDetail(ProjetDetail e);

    ProjetDetail updateProjetDetail(ProjetDetail e);

    ProjetDetail retrieveProjetDetail(Long idProjet);

    void removeProjetDetail(Long idProjet);


}