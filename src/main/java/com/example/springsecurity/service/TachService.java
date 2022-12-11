package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Tache;
import com.example.springsecurity.Repository.TachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TachService implements ITache{

    private TachRepository tachRepository;
    private IUserService user;

    @Override
    public Tache CreateTache(Tache T){
        return tachRepository.save(T);
    }
    @Override
    public Tache GeTache(Long T){
        return tachRepository.findById(T).orElse(null);
    }
    @Override
    public List<Tache> GetAllTaches(){
        return tachRepository.findAll();
    }
    @Override
    public void DeleteTache(Long T){
        tachRepository.deleteById(T);
    }
    @Override
    public Tache UpdateTache(Tache e, Long id) {
        return tachRepository.findById(id)
                .map(element -> {
                    element.setName(e.getName());
                    element.setDescription(e.getDescription());
                    element.setType(e.getType());
                    return tachRepository.save(element);
                })
                .orElseGet(() -> {
                    e.setIdTache(id);
                    return tachRepository.save(e);
                });
    }
}
