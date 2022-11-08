package esprit.tn.Controller;

import esprit.tn.Entity.Etudiant;
import esprit.tn.Service.IEtudiantService;
import esprit.tn.Service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EtudiantC")
public class UniversiteController {
    @Autowired
    @GetMapping("/")
    public String hello() {return "hello world";}
    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Etudiant etudiant)
    {

}}
