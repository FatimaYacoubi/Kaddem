package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Equipe;

import java.util.List;
import java.util.Map;

public interface IEquipeService {

    public Long ajouterEquipe(Equipe e);
    public Iterable<Equipe> retrieveAllEquipe();

    public void deleteEquipe(Long id);
    Equipe updateEquipe(Equipe e);

    Equipe retrieveEquipe (Long idEquipe);
    public List<Equipe> search(String keyword);
    public void assignEquipeDeatilEquipe( Long idEquipe , Long idDetailEquipe);
    public Map<String, Integer> statistiqueEquipe();
}
