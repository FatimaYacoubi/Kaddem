package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Entity.Entreprise;
import com.example.springsecurity.Entity.Response;
import com.example.springsecurity.Repository.EntrepriseRepository;
import com.example.springsecurity.service.EntrepriseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/authentication")
public class EntrepriseController {
    @Autowired
    EntrepriseServiceImp entrserv;
    @Autowired
    EntrepriseRepository entrepriseRepository;
    @CrossOrigin(origins = "*")
    @PostMapping("/addEntreprise")
    @ResponseBody
    public Entreprise addEntreprise(@RequestBody Entreprise E)
    {
    E.setDistance(entrserv.calculateDistanceInKilometer(E));
        entrserv.ajouter_entreprise(E);

        return(E);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/updateEntreprise")
    @ResponseBody
    public Entreprise updateEntreprise(@RequestBody Entreprise E)
    {
        entrserv.update_entreprise(E);
        return(E);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/AllEntreprises")
    @ResponseBody
    public List<Entreprise> AllEntreprises()
    { return entrserv.contrat_entreprise();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/nomE/{nomEntreprise}")
    @ResponseBody
    public List<Entreprise> findbynomE(@PathVariable String nomEntreprise)
    { return entrepriseRepository.findEntrepriseByNomEntreprise(nomEntreprise);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteEntreprise/{idEntreprise}")
    @ResponseBody
    public List<Entreprise>deleteEntreprise(@PathVariable int idEntreprise)
    {
        entrepriseRepository.deleteById(idEntreprise);
        return entrepriseRepository.findAll();
    }
    @DeleteMapping("/findEntreprise/{idEntreprise}")
    @ResponseBody
    @CrossOrigin(origins = "*")

    public Entreprise FindEntrepriseparID(@PathVariable int idEntreprise)
    {
       return (entrepriseRepository.findById(idEntreprise)).get();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/distance")
    @ResponseBody
    public int distance(@RequestBody Entreprise E)
    {
        return entrserv.calculateDistanceInKilometer(E);

    }

    @GetMapping("/findAllEnPaginate")

    public Response getContrats(@RequestParam Optional<String> Specialite,
                                @RequestParam Optional<Integer> page,
                                @RequestParam Optional<Integer> size)
    {
        Page<Entreprise> entreprises = null;
        entreprises= entrepriseRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10)
                )
        );
        Response res = new Response(entreprises.getContent(), entreprises.getTotalPages(),
                entreprises.getNumber(), entreprises.getSize(),1);

        return res;
    } }
