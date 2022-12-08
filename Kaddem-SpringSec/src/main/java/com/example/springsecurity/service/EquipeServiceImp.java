package com.example.springsecurity.service;

import com.example.springsecurity.Entity.DetailEquipe;
import com.example.springsecurity.Entity.Equipe;
import com.example.springsecurity.Repository.DetailEquipeRepository;
import com.example.springsecurity.Repository.EquipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    DetailEquipeRepository detailEquipeRepository;

    public Long ajouterEquipe(Equipe e) {
        equipeRepository.save(e);
        log.info("Ajouter Equipe");
        return e.getIdEquipe();
    }

    @Override
    public Iterable<Equipe> retrieveAllEquipe() {return equipeRepository.findAll();}

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);}

    @Override
    public Equipe updateEquipe(Equipe e) {return equipeRepository.save(e);}

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    public List<Equipe> search(String keyword) {
        if (keyword != null) {
            return equipeRepository.search(keyword);
        }
        return equipeRepository.findAll();
    }
    @Override
    public Map<String, Integer> statistiqueEquipe(){
        Map<String, Integer> graphData = new TreeMap<>();
        List<String> ldp=equipeRepository.stats();

        for (String str:ldp )
        {

            String[] res=	str.split(",",2);
            graphData.put(res[0], Integer.parseInt( res[1]) ) ;

        }

        //System.out.println(partenaireRepository.stats());
        return graphData   ;
    }
    public void assignEquipeDeatilEquipe( Long idEquipe , Long idDetailEquipe) {

        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        DetailEquipe detailEquipe = detailEquipeRepository.findById(idDetailEquipe).orElse(null);
        // departement.getEtudiants().add(etudiant);
        // departementRepository.save(departement);
        equipe.setDetailEquipe(detailEquipe);
        equipeRepository.save(equipe);
    }
}


