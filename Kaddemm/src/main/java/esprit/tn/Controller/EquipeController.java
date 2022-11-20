package esprit.tn.Controller;


import esprit.tn.Entity.Equipe;
import esprit.tn.Service.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EquipeC")
public class EquipeController {
    @Autowired
    IEquipeService EquipeService;
    @GetMapping("/")
    public String hello() {return "hello world";}
    @PostMapping("/addEquipe")
    @ResponseBody
    public void addEquipe(@RequestBody Equipe Equipe)
    {
        EquipeService.ajouter_Equipe(Equipe);
    }
    @PostMapping("/updateEquipe")
    @ResponseBody
    public void updateEquipe(@RequestBody Equipe Equipe)
    {
        EquipeService.update_Equipe(Equipe);
    }
    @PostMapping("/deleteEquipe")
    @ResponseBody
    public void deleteEquipe(@RequestBody Equipe Equipe)
    {
        EquipeService.delete_Equipe(Equipe.getIdEquipe());
    }
    @PostMapping("/AllEquipes")
    @ResponseBody
    public void AllEquipes()
    { EquipeService.Equipe_List();
    }
}
