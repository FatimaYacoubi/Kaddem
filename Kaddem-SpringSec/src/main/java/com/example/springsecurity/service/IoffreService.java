package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Offre;
import tn.esprit.spring.model.MailRequest;

import java.util.List;
import java.util.Optional;

public interface IoffreService {

    public Long ajouterOffre(Offre o, Long id);
    public Iterable<Offre> retrieveAllOffre();
    Offre retrieveOffre(Long idOffre);

    public void deleteOffre(Long id);
    Offre updateOffre(Offre o);
    public void assignOffreToPartenaire( Long idOffre , Long idPartenaire);


}
