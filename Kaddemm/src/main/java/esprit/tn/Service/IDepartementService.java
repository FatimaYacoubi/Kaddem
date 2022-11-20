package esprit.tn.Service;

import esprit.tn.Entity.Departement;

import java.util.List;

public interface IDepartementService {
    public Integer ajouter_departement(Departement e);
    public String delete_departement(Integer id);
    public List<Departement> departement_List() ;
    public void update_departement(Departement e) ;
    public String deleteAllE();
}
