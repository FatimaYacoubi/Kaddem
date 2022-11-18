package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.services.IProjet;

import java.util.List;

@RestController
@RequestMapping("/ProjetC")
public class ProjetController {
    @Autowired
    IProjet iProjet;

    @GetMapping("/getallProjets")
    @ResponseBody
    public List<Projet> getalliProjets()
    {
        return    iProjet.retrieveAllProjets();
    }



    @PostMapping("/addProjet")
    @ResponseBody
    public Projet addEtudiant(@RequestBody Projet projet)
    {
        iProjet.ajouter_projet(projet);

        return projet;
    }


    @PutMapping("/updateProjet")
    @ResponseBody
    public Projet updateEtudiant(@RequestBody Projet projet)
    {
        iProjet.updateProjet(projet);
        return  projet;
    }

    @DeleteMapping("/deleteProjet")
    @ResponseBody
    public void removeEtudiant(Long idprojet)
    {
        iProjet.removeProjet(idprojet);
    }

    @GetMapping("/getProjetbyid/{id}")
    @ResponseBody
    public Projet retrieveEtudiant(Long idprojet)
    {
        return iProjet.retrieveProjet(idprojet);

    }
}
