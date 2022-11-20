package esprit.tn.Controller;


import esprit.tn.Entity.DetailEquipe;
import esprit.tn.Service.IDetailEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DetailEquipeC")
public class DetailEquipeController {
    @Autowired
    IDetailEquipe DetailEquipeService;
    @GetMapping("/")
    public String hello() {return "hello world";}
    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public void addDetailEquipe(@RequestBody DetailEquipe DetailEquipe)
    {
        DetailEquipeService.ajouter_DetailEquipe(DetailEquipe);
    }
    @PostMapping("/updateDetailEquipe")
    @ResponseBody
    public void updateDetailEquipe(@RequestBody DetailEquipe DetailEquipe)
    {
        DetailEquipeService.update_DetailEquipe(DetailEquipe);
    }
    @PostMapping("/deleteDetailEquipe")
    @ResponseBody
    public void deleteDetailEquipe(@RequestBody DetailEquipe DetailEquipe)
    {
        DetailEquipeService.delete_DetailEquipe(DetailEquipe.getIdDetailEquipe());
    }
    @PostMapping("/AllDetailEquipes")
    @ResponseBody
    public void AllDetailEquipes()
    { DetailEquipeService.DetailEquipe_List();
    }
}
