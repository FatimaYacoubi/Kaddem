package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Universite;
import com.example.springsecurity.Repository.UniversiteRepository;
import com.example.springsecurity.service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/authentication/UniversiteC")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;
    @Autowired
    UniversiteRepository universiteRepository;

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public Iterable<Universite>  GetAllUniversite(){
        return iUniversiteService.retrieveAllUniversite();
    }
    @GetMapping("/UniversiteById/{universite-id}")
    @CrossOrigin(origins = "*")
    public Universite  GetUniversitebyId(@PathVariable("universite-id") Long Id){
        return iUniversiteService.retrieveUniversite(Id);
    }
    @PostMapping("/addUniversite")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public void addUniversite(@RequestBody Universite universite) {
        iUniversiteService.ajouterUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public Universite updateUniversite(@RequestBody Universite universite  ) {
        iUniversiteService.updateUniversite(universite);
        return universite;
    }

    @DeleteMapping("/deleteUniversite/{universite-id}")
    @ResponseBody
    @CrossOrigin(origins = "*")
    public void deleteUniversite(@PathVariable("universite-id") Long universiteId ) {
        iUniversiteService.deleteUniversite(universiteId);
    }

    @PutMapping(value = "/affectationUni_dep/{Uni-id}/{dep-id}")
    @CrossOrigin(origins = "*")
    public void affectationUniversiteDepartement(@PathVariable("Uni-id") Long UniId ,@PathVariable("dep-id") Long depId )
    {
        iUniversiteService.assignUniversiteToDepartement(UniId,depId);
    }

    @GetMapping("/sort")
    Page<Universite> SortUniversite(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return universiteRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5,
                        Sort.Direction.ASC, sortBy.orElse("id")
                )
        );
    }
}
