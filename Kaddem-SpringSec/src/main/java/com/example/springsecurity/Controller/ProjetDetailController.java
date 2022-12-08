package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.ProjetDetail;
import com.example.springsecurity.Repository.ProjetDetailRepository;
import com.example.springsecurity.service.IProjetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins ="*" )
@RestController
@RequestMapping("/api/authentication/ProjetDetailC")
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



}
