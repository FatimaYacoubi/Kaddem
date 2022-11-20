package esprit.tn.Service;

import esprit.tn.Entity.Equipe;
import esprit.tn.Repository.EquipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EquipeServiceImp implements IEquipeService{
    @Autowired
    EquipeRepository EquipeRepository;
    public Integer ajouter_Equipe(Equipe e)
    {
        EquipeRepository.save(e);
        log.info("ajouter Equiper");
        return (1);
    }
    public String delete_Equipe(Integer id) {
        EquipeRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    public List<Equipe> Equipe_List() {
        return EquipeRepository.findAll();

    }

    public void update_Equipe(Equipe e) {
        EquipeRepository.save(e);

    }

    public String deleteAllE() {
        EquipeRepository.deleteAll();
        return "deleted";
    }

}
