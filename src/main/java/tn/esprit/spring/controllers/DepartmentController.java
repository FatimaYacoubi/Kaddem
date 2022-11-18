package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IDepartment;

import java.util.List;

@RestController
@RequestMapping("/departmentC")
public class DepartmentController {

    @Autowired
    IDepartment iDepartment;

    @GetMapping( "/")
    public String  hello(){return "Hello world ";}


    @GetMapping("/getalldepartments")
    @ResponseBody
    public List<Departement> getalldepartments()
    {
        return    iDepartment.retrieveAllDepartements();
    }



    @PostMapping("/adddepartment")
    @ResponseBody
    public Departement adddepartment(@RequestBody Departement departement)
    {
        iDepartment.addDepartement(departement);

        return departement;
    }


    @PutMapping("/updatedepartement")
    @ResponseBody
    public Departement updateEtudiant(@RequestBody Departement departement)
    {
        iDepartment.updateDepartement(departement);
        return  departement;
    }

    @GetMapping("/getdepartementbyid/{id}")
    @ResponseBody
    public Departement getdepartementbyid(Long idDepart)
    {
        return    iDepartment.retrieveDepartement(idDepart);
    }
}
