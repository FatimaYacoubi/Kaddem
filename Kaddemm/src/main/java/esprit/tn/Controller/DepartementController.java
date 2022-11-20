package esprit.tn.Controller;


import esprit.tn.Entity.Departement;
import esprit.tn.Service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DepartementC")
public class DepartementController {
    @Autowired
    IDepartementService departementService;
    @GetMapping("/")
    public String hello() {return "hello world";}
    @PostMapping("/addDepartement")
    @ResponseBody
    public void addDepartement(@RequestBody Departement departement)
    {
        departementService.ajouter_departement(departement);
    }
    @PostMapping("/updateDepartement")
    @ResponseBody
    public void updateDepartement(@RequestBody Departement departement)
    {
        departementService.update_departement(departement);
    }
    @PostMapping("/deleteDepartement")
    @ResponseBody
    public void deleteDepartement(@RequestBody Departement departement)
    {
        departementService.delete_departement(departement.getIdDepart());
    }
    @PostMapping("/AllDepartements")
    @ResponseBody
    public void AllDepartements()
    { departementService.departement_List();
    }
}
