package esprit.tn.Service;

import esprit.tn.Entity.DetailEquipe;

import java.util.List;

public interface IDetailEquipe {
    public Integer ajouter_DetailEquipe(DetailEquipe e);
    public String delete_DetailEquipe(Integer id);
    public List<DetailEquipe> DetailEquipe_List() ;
    public void update_DetailEquipe(DetailEquipe e) ;
    public String deleteAllE();
}
