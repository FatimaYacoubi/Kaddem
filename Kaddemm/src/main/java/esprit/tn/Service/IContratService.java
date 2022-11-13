package esprit.tn.Service;
import esprit.tn.Entity.Contrat;
import java.util.List;

public interface IContratService {
    public void ajouter_contrat(Contrat e);
    public String delete_contrat(Integer id);
    public List<Contrat> contrat_List() ;
    public void update_contrat(Contrat e) ;
    public String deleteAllC();
}
