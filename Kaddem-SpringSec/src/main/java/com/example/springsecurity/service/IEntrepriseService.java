package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Entreprise;

import java.util.List;

public interface IEntrepriseService {
    public void ajouter_entreprise(Entreprise E);
    public Entreprise update_entreprise(Entreprise E);
    public List<Entreprise> contrat_entreprise() ;
    public String delete_contrat(Integer id) ;
    }
