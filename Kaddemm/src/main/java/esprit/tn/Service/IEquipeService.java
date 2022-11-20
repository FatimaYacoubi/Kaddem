package esprit.tn.Service;

import esprit.tn.Entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public Integer ajouter_Equipe(Equipe e);
    public String delete_Equipe(Integer id);
    public List<Equipe> Equipe_List() ;
    public void update_Equipe(Equipe e) ;
    public String deleteAllE();
}
