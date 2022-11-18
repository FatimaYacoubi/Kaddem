package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEquipe;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipeC")
public class EquipeController {


    @Autowired
    IEquipe iEquipe;

    @GetMapping( "/")
    public String  hello(){return "Hello world ";}

    @GetMapping("/getallEquipe")
    @ResponseBody
    public List<Equipe> getallEquipe()
    {
        return    iEquipe.retrieveAllEquipes();
    }



    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe equipe)
    {
        iEquipe.addEquipe(equipe);

        return equipe;
    }


    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe equipe)
    {
        iEquipe.updateEquipe(equipe);
        return  equipe;
    }


    @GetMapping("/getEquipebyid/{id}")
    @ResponseBody
    public Optional<Equipe> getEquipebyid(Long idEquipe)
    {
        return    iEquipe.retrieveEquipe(idEquipe);
    }







}
