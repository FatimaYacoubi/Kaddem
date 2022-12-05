package com.example.springsecurity.service;
import com.example.springsecurity.Entity.Contrat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IContratService {
    public void ajouter_contrat(Contrat e);
    public String delete_contrat(Integer id);
    public List<Contrat> contrat_List() ;
    public String deleteAllC();

    Contrat update_contrat(Contrat contrat);

    Contrat addContrat(Contrat contrat);

    List<Contrat> getPercentageGroupBySpecialite();
}
