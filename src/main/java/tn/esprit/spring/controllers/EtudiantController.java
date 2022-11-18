package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEtudiantService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/EtudiantC")
public class EtudiantController {
        @Autowired
        IEtudiantService etudiantService;

        @GetMapping( "/")
        public String  hello(){return "Hello world ";}


    @GetMapping("/getallEtudiant")
    @ResponseBody
    public List<Etudiant> getallEtudiant()
    {
     return    etudiantService.retrieveAllEtudiants();
    }



        @PostMapping("/addEtudiant")
        @ResponseBody
        public Etudiant addEtudiant(@RequestBody Etudiant etudiant)
        {
            etudiantService.ajouter_etudiant(etudiant);

    return etudiant;
        }


        @PutMapping("/updateEtudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
        {
            etudiantService.updateEtudiant(etudiant);
            return  etudiant;
        }

        @DeleteMapping("/deleteEtudiant")
    @ResponseBody
    public void removeEtudiant(Long idEtudiant)
        {
            etudiantService.removeEtudiant(idEtudiant);
        }

        @GetMapping("/getEtudiantbyid/{id}")
    @ResponseBody
    public Etudiant retrieveEtudiant(Long idEtudiant)
        {
            return etudiantService.retrieveEtudiant(idEtudiant);

        }
}
