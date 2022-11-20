package esprit.tn.Service;

import esprit.tn.Entity.DetailEquipe;
import esprit.tn.Repository.DetailEquipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DetailEquipeServiceImp implements IDetailEquipe{
    @Autowired
    DetailEquipeRepository DetailEquipeRepository;
    public Integer ajouter_DetailEquipe(DetailEquipe e)
    {
        DetailEquipeRepository.save(e);
        log.info("ajouter DetailEquiper");
        return (1);
    }
    public String delete_DetailEquipe(Integer id) {
        DetailEquipeRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    public List<DetailEquipe> DetailEquipe_List() {
        return DetailEquipeRepository.findAll();

    }

    public void update_DetailEquipe(DetailEquipe e) {
        DetailEquipeRepository.save(e);

    }

    public String deleteAllE() {
        DetailEquipeRepository.deleteAll();
        return "deleted";
    }

}
