package esprit.tn.Controller;

import esprit.tn.Entity.Contrat;
import esprit.tn.Entity.Etudiant;
import esprit.tn.Repository.ContratRepository;
import esprit.tn.Repository.EtudiantRepository;
import esprit.tn.Service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/ContratC")
public class ContratController {


    @Autowired
    IContratService contratService;
    @Autowired
    ContratRepository contratrepo;
    @Autowired
    EtudiantRepository etudiantRepository;
    @PostMapping("/addContrat")
    @ResponseBody
    public Contrat addContrat(@RequestBody Contrat contrat)
    {
        contratService.ajouter_contrat(contrat);
        int x= contrat.getEtudiantC().getIdEtudiant();
        Etudiant e=etudiantRepository.findById(x).get();
        System.out.println(x);

        if(e==null)
        {         System.out.println("null");

            Etudiant ee= new Etudiant();
          contrat.setEtudiantC(ee);
            etudiantRepository.save(ee);


        } else {
            System.out.println(e.getNomE());
            contrat.setEtudiantC(e);
        }
        contratrepo.save(contrat);
        return (contrat);
    }
    @CrossOrigin(origins = "*")

    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat)

    {contratService.update_contrat(contrat);
        Etudiant e=etudiantRepository.findById(11).get();
        System.out.println(11);

        if(e==null)
        {         System.out.println("null");

            Etudiant ee= new Etudiant();
            contrat.setEtudiantC(ee);
            etudiantRepository.save(ee);


        } else {
            System.out.println(e.getNomE());
            contrat.setEtudiantC(e);
        }
        contratrepo.save(contrat);
        return (contrat);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteContrat/{idContrat}")
    @ResponseBody
    public List<Contrat>deleteContrat(@PathVariable int idContrat)
    {
        contratrepo.deleteById(idContrat);
        return contratrepo.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/detailContrat")
    @ResponseBody
    public Contrat detail(@RequestBody String descriptionContrat)
    {         System.out.println(contratrepo.getContratByDescriptionContrat(descriptionContrat));
               System.out.println(descriptionContrat);

        return contratrepo.getContratByDescriptionContrat(descriptionContrat);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/Contrat/{idContrat}")
    @ResponseBody
    public Contrat detail(@PathVariable int idContrat)
    {         return contratrepo.findById(idContrat).get();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/AllContrats")
    @ResponseBody
    public List<Contrat> AllContrats()
    { return contratService.contrat_List();

    }

}