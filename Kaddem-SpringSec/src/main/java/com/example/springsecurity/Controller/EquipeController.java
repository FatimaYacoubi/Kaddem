package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Equipe;
import com.example.springsecurity.Repository.EquipeRepository;
import com.example.springsecurity.service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/authentication")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;
    @Autowired
    EquipeRepository equipeRepository;

    @GetMapping("/AffichageEquipe")
    @CrossOrigin(origins = "*")
    public Iterable<Equipe>  GetAllEquipe(){
        return iEquipeService.retrieveAllEquipe();
    }

    @PostMapping("/addEquipe")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public void addEquipe(@RequestBody Equipe equipe) {
        iEquipeService.ajouterEquipe(equipe);
    }

    @GetMapping("/retrieve-equipe/{equipe-id}")
    @CrossOrigin(origins = "*")

    public Equipe retrieveEquipe(@PathVariable("equipe-id") Long equipeId) {
        return iEquipeService.retrieveEquipe(equipeId);
    }

        @PutMapping("/updateEquipe")
        @CrossOrigin(origins = "*")
        @ResponseBody
    public void updateEquipe(@RequestBody Equipe equipe) {
        iEquipeService.updateEquipe(equipe);
    }

    @DeleteMapping("/deleteEquipe/{equipe-id}")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public void deleteEquipe(@PathVariable("equipe-id") Long equipeId ) {
        iEquipeService.deleteEquipe(equipeId);
    }
    @GetMapping("/search")
    @CrossOrigin(origins = "*")
    public List<Equipe> viewHomePage(String keyword) {
        List<Equipe> listEquipe = iEquipeService.search(keyword);
        return listEquipe;
    }

  /*  @GetMapping
    @CrossOrigin(origins = "*")
    Page<Equipe> SortEquipe(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return equipeRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC, sortBy.orElse("idEquipe")
                )
        );
    }*/
    @GetMapping("/retrieve-all-equipe-stats")
    @CrossOrigin(origins = "*")
    @ResponseBody
    public Map<String, Integer> statistiqueEquipe() {
        Map<String, Integer> listEquipe = iEquipeService.statistiqueEquipe();
        return listEquipe;
    }

    @PutMapping(value = "/affectationEtudiant_dep/{equipe-id}/{detailEquipe-id}")
    @CrossOrigin(origins = "*")
    public void affectationEquipeDetailEquipe(@PathVariable("equipe-id") Long idEquipe,@PathVariable("detailEquipe-id") Long idDetailEquipe )
    {
        iEquipeService.assignEquipeDeatilEquipe(idEquipe,idDetailEquipe);
    }
}

