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
    public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
    public int calculateDistanceInKilometer(Entreprise e) {

        double latDistance = Math.toRadians(e.getLatitude() - 36.24255502127699);
        double lngDistance = Math.toRadians(e.getLongitude() - 9.476723745103257);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(e.getLatitude())) * Math.cos(Math.toRadians( 36.24255502127699))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
    }

}
