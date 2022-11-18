package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.services.IUniversite;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {

@Autowired
    IUniversite iUniversite;

    @GetMapping( "/")
    public String  hello(){return "Hello world ";}


    @GetMapping("/getallUniversite")
    @ResponseBody
    public List<Universite> getallUniversite()
    {
        return    iUniversite.retrieveAllUniversites();
    }



    @PostMapping("/addUniversite")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite universite)
    {
        iUniversite.addUniversite(universite);

        return universite;
    }


    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite universite)
    {
        iUniversite.updateUniversite(universite);
        return  universite;
    }

    @GetMapping("/getUniversitebyid/{id}")
    @ResponseBody
    public Optional<Universite> getUniversitebyid(Long idUniversite)
    {
        return iUniversite.findUniversiteById(idUniversite);

    }
}
