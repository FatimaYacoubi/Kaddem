package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.services.IProjet;

import java.util.List;
@CrossOrigin(origins ="*" )
@RestController
@RequestMapping("/ProjetC")
@AllArgsConstructor
public class ProjetController {

   private IProjet iProjet;

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


    @PutMapping("/updateProjet")
    @ResponseBody
    public Projet updateProjets(@RequestBody Projet projet)
    {
        iProjet.updateProjet(projet);
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




}
