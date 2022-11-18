package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.EquipeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EquipeServiceImp implements IEquipe {


    @Autowired
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
         equipeRepository.save(e);
        return e;
    }

    @Override
    @Transactional
    public Equipe updateEquipe(Equipe e) {
        List<Equipe> etud = retrieveAllEquipes();
        for(Equipe r:etud){
            if(e.getIdEquipe()==r.getIdEquipe()){
                r.setNomEquipe(e.getNomEquipe());
                r.setNiveau(e.getNiveau());
                r.setDetailequipe(e.getDetailequipe());
                r.setEtudiants(e.getEtudiants());

                return r;
            }
        }

        return null;
    }

    @Override
    public Optional<Equipe> retrieveEquipe(Long id) {

        return equipeRepository.findById(id);
    }
}
