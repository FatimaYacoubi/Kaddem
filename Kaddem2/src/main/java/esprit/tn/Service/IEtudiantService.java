package esprit.tn.Service;

import esprit.tn.Entity.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEtudiantService {
public Long ajouter_etudiant(Etudiant e);
    public String delete_etudiant(Long id);
    public List<Etudiant> etudiant_List() ;
    public void update_Etudiant(Etudiant e) ;
    public String deleteAllE();

    }
