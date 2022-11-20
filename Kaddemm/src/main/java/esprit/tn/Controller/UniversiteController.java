package esprit.tn.Controller;

import esprit.tn.Entity.Etudiant;
import esprit.tn.Service.IEtudiantService;
import esprit.tn.Service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import esprit.tn.Entity.Universite;
import esprit.tn.Service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {
    @Autowired
    IUniversiteService UniversiteService;
    @GetMapping("/")
    public String hello() {return "hello world";}
    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Universite universite)
    {
        UniversiteService.ajouter_Universite(universite);
    }
    @PostMapping("/updateUniversite")
    @ResponseBody
    public void updateUniversite(@RequestBody Universite universite)
    {
        UniversiteService.update_Universite(universite);
    }
    @PostMapping("/deleteUniversite")
    @ResponseBody
    public void deleteUniversite(@RequestBody Universite universite)
    {
        UniversiteService.delete_Universite(universite.getIdUniv());
    }
    @PostMapping("/AllUniversites")
    @ResponseBody
    public void AllUniversites()
    { UniversiteService.Universite_List();
    }
    @PutMapping(value = "/affectationEtudiant_Departement/{idDepartement}/{idUniversite}")
    public void affectationUniversitetoDepartement(@PathVariable("idDepartement}") Integer idDepartement ,@PathVariable("idUnivesite") Integer idUniversite )
    {
        UniversiteService.assignUniversitetoDepartement(idDepartement,idUniversite);
    }
}

