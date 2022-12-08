package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.DetailEquipe;
import com.example.springsecurity.service.IDetailEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/authentication")
public class DetailEquipeController {

    @Autowired
    IDetailEquipe idetailEquipe;

    @GetMapping("/AffichageDetailEquipe")
    @CrossOrigin(origins = "*")
    public Iterable<DetailEquipe>  GetAllDetailEquipe(){
        return idetailEquipe.retrieveAllDetailEquipe();
    }
    @GetMapping("/DetailEquipeById/{detailEquipe-id}")
    @CrossOrigin(origins = "*")
    public Optional< DetailEquipe > GetDetailEquipebyId(@PathVariable("detailEquipe-id") Long Id){
        return idetailEquipe.findDetailEquipeById(Id);
    }
    @PostMapping("/addDetailEquipe")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public void addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        idetailEquipe.ajouterDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailEquipe")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public void updateDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        idetailEquipe.updateDetailEquipe(detailEquipe);
    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public void deleteDetailEquipe(@PathVariable("id") Long detailEquipeId ) {
        idetailEquipe.deleteDetailEquipe(detailEquipeId);
    }
}
