package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.Offre;
import com.example.springsecurity.service.EmailService;
import com.example.springsecurity.service.IoffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.model.MailRequest;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/authentication/OffreC")
@CrossOrigin(origins = "http://localhost:4200")
public class OffreController {

    @Autowired
    IoffreService ioffreService;

    @Autowired
    EmailService emailService;
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Offre>  GetAllOffre(){
        return ioffreService.retrieveAllOffre();
    }

    @GetMapping("/retrieve-Offre/{Offre-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Offre retrieveOffre(@PathVariable("Offre-id") Long OffreId) {
        return ioffreService.retrieveOffre(OffreId);
    }

    @PostMapping("/addOffre")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void addOffre(@RequestBody Offre o ) {
        ioffreService.ajouterOffre(o);
    }

    @PutMapping("/updateOffre")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void updatePOffre(@RequestBody Offre offre) {
        ioffreService.updateOffre(offre);
    }

    @DeleteMapping("/deleteOffre/{Offre-id}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteEtudiant(@PathVariable("Offre-id") Long OffreId ) {
        ioffreService.deleteOffre(OffreId);
    }
    @PutMapping(value = "/affectationOffre_Partenaire/{offre-id}/{par-id}")
    public void affectationOffrePartenaire(@PathVariable("offre-id") Long offretId ,@PathVariable("par-id") Long parId )
    {
        ioffreService.assignOffreToPartenaire(offretId,parId);
    }

  /**  @GetMapping("/emailt/")
    public List<Offre> email(){
        return ioffreService.retrieveoffreParPartenaaire() ;
    }*/

   /**@RequestMapping(method = RequestMethod.POST,path = "/register")
    @ResponseBody
    public String register(@RequestBody Universite userInfo) throws Exception {
        emailService.sendEmail(userInfo);
        return "Email Sent..!";}*/



    }
