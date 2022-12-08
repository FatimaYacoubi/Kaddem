package com.example.springsecurity.service;


import com.example.springsecurity.Entity.Partenaire;
import com.example.springsecurity.Entity.Universite;
import com.example.springsecurity.Repository.PartenaireRepository;
import com.example.springsecurity.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
@AllArgsConstructor
public class PartenaireServiceImp implements IpartenaireService{

    PartenaireRepository partenaireRepository;
    UniversiteRepository universiteRepository;

    @Override
    public Long ajouterPartenaire(Partenaire p) {
        partenaireRepository.save(p);
        log.info("Ajouter Offre");
        return p.getIdPartenaire();
    }
    @Override
    public Iterable<Partenaire> retrieveAllPartenaire() {return partenaireRepository.findAll();}


    @Override
    public void deletePartenaire(Long id) {
        partenaireRepository.deleteById(id);}

    @Override
    public Partenaire updatePartenaire(Partenaire p , Long idPar) {
       Partenaire par = partenaireRepository.findById(idPar).get();
       par.setNomPartenaire(p.getNomPartenaire());
        par.setLocalisation(p.getLocalisation());
        par.setNumTelPar(p.getNumTelPar());
        par.setMobilite(p.isMobilite());
        par.setSupport(p.getSupport());
        par.setEmail(p.getEmail());
        par.setUniversites(p.getUniversites());

        return partenaireRepository.save(par);}

    @Override
    public Partenaire retrievePartenaire(Long idPartenaire) {
        return partenaireRepository.findById(idPartenaire).get();
    }


    @Override
    public void assignPartenaireToUniversite( Long idPartenaire , Long idUniver) {

        Partenaire partenaire = partenaireRepository.findById(idPartenaire).orElse(null);
        Universite universite = universiteRepository.findById(idUniver).orElse(null);
        partenaire.setUniversites(universite);
        partenaireRepository.save(partenaire);
    }


    public List<Partenaire> search(String keyword) {
        if (keyword != null) {
            return partenaireRepository.search(keyword);
        }
        return partenaireRepository.findAll();
    }
    @Override
    public Map<String, Integer> statistiquePartenaire(){
        Map<String, Integer> graphData = new TreeMap<>();
        List<String> ldp=partenaireRepository.stats();

        for (String str:ldp )
        {

            String[] res=	str.split(",",2);
            graphData.put(res[0], Integer.parseInt( res[1]) ) ;

        }

        //System.out.println(partenaireRepository.stats());
        return graphData   ;
    }

    @Transactional
   public Partenaire AddAndAssignEvent(Partenaire p ,Long idUniversite){

        Universite univ =universiteRepository.findById(idUniversite).orElse(null);
        p.setUniversites(univ);
        partenaireRepository.save(p);
      return partenaireRepository.save(p);

   }

}
