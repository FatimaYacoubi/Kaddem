package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IContrat;

import java.util.List;

@RestController
@RequestMapping("/contractC")
public class ContratController {

    @Autowired
    IContrat iContrat;

    @GetMapping( "/")
    public String  hello(){return "Hello world ";}


    @GetMapping("/getallContrat")
    @ResponseBody
    public List<Contrat> getallContrat()
    {
        return    iContrat.retrieveAllContrats();
    }



    @PostMapping("/addiContrat")
    @ResponseBody
    public Contrat addiContrat(@RequestBody Contrat contrat)
    {
        iContrat.addContrat(contrat);

        return contrat;
    }


    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat)
    {
        iContrat.updateContrat(contrat);
        return  contrat;
    }

    @DeleteMapping("/deleteContrat")
    @ResponseBody
    public void deleteContrat(Long idContrat)
    {
        iContrat.removeContrat(idContrat);
    }


    @GetMapping("/getContratbyid/{id}")
    @ResponseBody
    public Contrat getContratbyid(Long idContrat)
    {
        return iContrat.retrieveContrat(idContrat);

    }





}
