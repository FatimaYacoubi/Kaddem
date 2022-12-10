package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.entity.ProjetDetail;
import tn.esprit.spring.repositories.ProjetDetailRepository;
import tn.esprit.spring.services.IProjetDetail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins ="*" )
@RestController
@RequestMapping("/ProjetDetailC")
public class ProjetDetailController {

    @Autowired
    IProjetDetail iProjetDetail;

    @Autowired
    ProjetDetailRepository projetDetailRepository;

    @GetMapping("/getallProjetdetails")
    @ResponseBody
    public List<ProjetDetail> getallProjetdetails()
    {
        return  iProjetDetail.retrieveAllProjetDetails();
    }



    @PostMapping("/addProjetDetail")
    @ResponseBody
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail ProjetDetail)
    {
        iProjetDetail.ajouter_ProjetDetail(ProjetDetail);

        return ProjetDetail;
    }


    @PutMapping("/updateProjetDetail")
    @ResponseBody
    public ProjetDetail updateProjetDetail(@RequestBody ProjetDetail ProjetDetail)
    {
        iProjetDetail.updateProjetDetail(ProjetDetail);
        return  ProjetDetail;
    }

    @DeleteMapping("/deleteProjetDetail/{idprojet}")
    @ResponseBody
    public void removeProjetDetail(@PathVariable Long idprojet)
    {
        iProjetDetail.removeProjetDetail(idprojet);
    }

    @GetMapping("/getProjetbyid/{idprojet}")
    @ResponseBody
    public ProjetDetail retrieveProjetDetail(@PathVariable Long idprojet)
    {
        return iProjetDetail.retrieveProjetDetail(idprojet);

    }
    @GetMapping("/retrieveAllProjetDetailsbytechnologie/{techno}/{desc}")
    @ResponseBody
    public List<ProjetDetail> retrieveAllProjetDetailsbytechnologieanddescription(@PathVariable String techno ,@PathVariable String desc )
    {
        return iProjetDetail.retrieveAllProjetDetailsbytechnologieanddescription(techno,desc);

    }

    @GetMapping("/findByDateDebutBetween/{datedeb}/{datefin}")
    @ResponseBody
    public List<ProjetDetail> findByDateDebutBetween(@PathVariable String datedeb ,@PathVariable String datefin ) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(datedeb);
        Date date2 = formatter.parse(datefin);
        return iProjetDetail.findByDateDebutBetween(date,date2);

    }


}
