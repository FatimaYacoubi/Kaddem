package esprit.tn.Service;

import esprit.tn.Entity.Contrat;
import esprit.tn.Repository.ContratRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
public class ContratServiceImp implements IContratService {


    @Autowired
    ContratRepository contratRepository;

    @Override
    public void ajouter_contrat(Contrat e) {
        contratRepository.save(e);
        log.info("ajouter Contratr");
           }

    @Override
    public String delete_contrat(Integer id) {
        contratRepository.deleteById(id);
        log.info("deleted ");
        return "DEleted";
    }

    @Override
    public List<Contrat> contrat_List() {
        return contratRepository.findAll();
    }

    @Override
    public void update_contrat(Contrat e) {
        contratRepository.save(e);

    }

    @Override
    public String deleteAllC() {
        contratRepository.deleteAll();
        return "deleted";    }
}
