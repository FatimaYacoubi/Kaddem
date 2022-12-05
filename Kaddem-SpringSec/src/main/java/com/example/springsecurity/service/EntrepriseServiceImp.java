package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Entreprise;
import com.example.springsecurity.Repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EntrepriseServiceImp implements IEntrepriseService {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    public void ajouter_entreprise(Entreprise E) {
        entrepriseRepository.save(E);
    }

    public Entreprise update_entreprise(Entreprise E) {
        int x = E.getIdEntreprise();
        Entreprise EE = entrepriseRepository.findById(x).get();
        EE.setLocEntreprise(E.getLocEntreprise());
        EE.setNomEntreprise(E.getNomEntreprise());
        EE.setNbPlaceRest(E.getNbPlaceRest());
        EE.setLatitude(E.getLatitude());
        EE.setLongitude(E.getLongitude());
        return entrepriseRepository.save(EE);
    }
    public List<Entreprise> contrat_entreprise() {
        return entrepriseRepository.findAll();
    }
    public String delete_contrat(Integer id) {
        entrepriseRepository.deleteById(id);
        return "DEleted";
    }
}
