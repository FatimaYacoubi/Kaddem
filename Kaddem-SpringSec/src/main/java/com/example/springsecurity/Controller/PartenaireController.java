package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Partenaire;
import com.example.springsecurity.service.IpartenaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/authentication/PartenaireC")
@CrossOrigin(origins = "http://localhost:4200")
public class PartenaireController {

    @Autowired
    IpartenaireService ipartenaireService;

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Partenaire>  GetAllPatenaire(){
        return ipartenaireService.retrieveAllPartenaire();
    }

    @GetMapping("/retrieve-partenaire/{Partenaire-id}")
    public Partenaire retrievePartenaire(@PathVariable("Partenaire-id") Long PartenaireId) {
        return ipartenaireService.retrievePartenaire(PartenaireId);
    }

    @PostMapping("/addPartenaire")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void addPartenaire(@RequestBody Partenaire Par) {
        ipartenaireService.ajouterPartenaire(Par);
    }

    @PutMapping("/updatePartenaire")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void updatePartenaire(@RequestBody Partenaire Par ) {
        ipartenaireService.updatePartenaire(Par);
    }
    @PostMapping (value = "/affectationPartenaireUniversite/{partenaire-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Partenaire affectationPartenaireUniversite( @RequestBody Partenaire Par ,@PathVariable("partenaire-id") Long PartenairetId   )
    {
        Partenaire etudiant1 = ipartenaireService.AddAndAssignEvent(Par,PartenairetId);
        return etudiant1;
    }

    @DeleteMapping("/deletePartenaire/{partenaire-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void deletePartenairet(@PathVariable("partenaire-id") Long PartenairetId ) {
        ipartenaireService.deletePartenaire(PartenairetId);
    }
    @PutMapping(value = "/affectationPartenaire_univer/{Par-id}/{uni-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void affectationPartenaireUniversite(@PathVariable("Par-id") Long partId ,@PathVariable("uni-id") Long UniId )
    {
        ipartenaireService.assignPartenaireToUniversite(partId,UniId);
    }

    @GetMapping("/retrieve-all-partenaire-stats")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Map<String, Integer> statistiqueProduit() {
        Map<String, Integer> listPatenaire = ipartenaireService.statistiquePartenaire();
        return listPatenaire;
    }

    @GetMapping("/search/{x}")
    @CrossOrigin(origins = "http://localhost:4200")
  public Iterable<Partenaire> viewHomePage( @PathVariable("x") String keyword) {
        Iterable<Partenaire> listPatenaire = ipartenaireService.search(keyword);
return listPatenaire;
    }

}
