package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.entity.paginationprojet;
import tn.esprit.spring.repositories.ProjetRepository;
import tn.esprit.spring.services.IProjet;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="*" )
@RestController
@RequestMapping("/ProjetC")
@AllArgsConstructor
public class ProjetController {

   private IProjet iProjet;

   @Autowired
    ProjetRepository projetRepository;

    @GetMapping("/getallProjets")
    @ResponseBody
    public List<Projet> getalliProjets()
    {
        return    iProjet.retrieveAllProjets();
    }



    @PostMapping("/addProjet/{idProjetdetail}")
    @ResponseBody
    public Projet addProjets(@RequestBody Projet projet,@PathVariable Long idProjetdetail)
    {
        iProjet.ajouter_projet(projet,idProjetdetail);

        return projet;
    }


    @PutMapping("/updateProjet/{idProjetdetail}")
    @ResponseBody
    public Projet updateProjets(@RequestBody Projet projet,@PathVariable Long idProjetdetail)
    {
        iProjet.updateProjet(projet,idProjetdetail);
        return  projet;
    }

    @DeleteMapping("/deleteProjet/{idprojet}")
    @ResponseBody
    public void removeProjets(@PathVariable Long idprojet)
    {
        iProjet.removeProjet(idprojet);
    }

    @GetMapping("/getProjetbyid/{idprojet}")
    @ResponseBody
    public Projet retrieveProjets(@PathVariable Long idprojet)
    {
        return iProjet.retrieveProjet(idprojet);

    }


    @GetMapping("/findAllEPaginate")

    public paginationprojet getContrats(@RequestParam Optional<Integer> page,  @RequestParam Optional<Integer> size)
    {
        Page<Projet> projets = null;
        projets= projetRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(5)
                )
        );
        paginationprojet res = new paginationprojet(projets.getContent(), projets.getTotalPages(),
                projets.getNumber(), projets.getSize());

        return res;
    }

}
