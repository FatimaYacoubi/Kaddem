package esprit.tn.Service;

import esprit.tn.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public Integer ajouter_Universite(Universite e);
    public String delete_Universite(Integer id);
    public List<Universite> Universite_List() ;
    public void update_Universite(Universite e) ;
    public String deleteAllE();

    void assignUniversitetoDepartement(Integer idDepartement, Integer idUniversite);
}
