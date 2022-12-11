package com.example.springsecurity.Controller;


import com.example.springsecurity.Entity.Contrat;
import com.example.springsecurity.Entity.EmailEntrepriseContrat;
import com.example.springsecurity.Entity.Response;
import com.example.springsecurity.Entity.Specialite;
import com.example.springsecurity.Repository.ContratRepository;
import com.example.springsecurity.Repository.EtudiantRepository;
import com.example.springsecurity.service.ContratExcelExporter;
import com.example.springsecurity.service.EmailContratEntrepriseImp;
import com.example.springsecurity.service.ExportContratService;
import com.example.springsecurity.service.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.data.domain.PageRequest.of;


@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/authentication")
public class ContratController {

    @Autowired
    IContratService contratService;

    @Autowired
    ContratRepository contratrepo;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    ExportContratService exportcontrat ;
    @PostMapping("/addContrat")
    @ResponseBody
    public ResponseEntity<InputStreamResource> addContrat(@RequestBody Contrat co)
    {

        contratService.ajouter_contrat(co);
        return null;

    }
    @CrossOrigin(origins = "*")

    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat contrat)

    {contratService.update_contrat(contrat);
        System.out.println(11);


        contratrepo.save(contrat);
        return (contrat);

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteContrat/{idContrat}")
    @ResponseBody
    public void deleteContrat(@PathVariable int idContrat)
    {
        contratrepo.deleteById(idContrat);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/detailContrat")
    @ResponseBody
    public Contrat detail(@RequestBody String descriptionContrat)
    {         System.out.println(contratrepo.getContratByDescriptionContrat(descriptionContrat));
               System.out.println(descriptionContrat);

        return contratrepo.getContratByDescriptionContrat(descriptionContrat);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/Contrat/{idContrat}")
    @ResponseBody
    public Contrat detail(@PathVariable int idContrat)
    {         return contratrepo.findById(idContrat).get();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/AllContrats")
    @ResponseBody
    public List<Contrat> AllContrats()
    { return contratService.contrat_List();

    }
    @CrossOrigin(origins = "*")

    @GetMapping("/export/pdf")
public ResponseEntity<InputStreamResource> exportTermspdf() {
    List<Contrat> contrats = (List<Contrat>) contratrepo.findAll();
    ByteArrayInputStream bais = exportcontrat.contratPDFReport(contrats);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=contrats.pdf");
    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
}
    @CrossOrigin(origins = "*")
@GetMapping("/export/excel")
   public void exportToExcel(HttpServletResponse response) throws IOException
    {
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachement;filename=contrats.xlsx";
        response.setHeader(headerKey,headerValue);
        List<Contrat> contrats = contratService.contrat_List();
        ContratExcelExporter excelExporter= new ContratExcelExporter(contrats);
        excelExporter.export(response);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/specialite/{specialite}")
    @ResponseBody
    public List<Contrat> findbyspecialite(@PathVariable String specialite)
    { return contratrepo.findContratBySpecialite(Specialite.valueOf(specialite));
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/chartbyspecialite")
    public List<Contrat> getGroupBySpecialite(){
return contratService.getPercentageGroupBySpecialite();
    }
    @Autowired
    private EmailContratEntrepriseImp emailService;
    @CrossOrigin(origins = "*")

    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailEntrepriseContrat details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment


    @GetMapping("/titi/{id}")
    public ResponseEntity<?> ShowUser(@PathVariable("id") Long id){
        contratService.getcontratbyidetudiant(id);
        return new ResponseEntity<>(contratService.getcontratbyidetudiant(id), HttpStatus.OK);
    }
    @GetMapping("/findAllEPaginate")

    public Response getContrats(@RequestParam Optional<String> Specialite,
                                                   @RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> size)
    {
        Page<Contrat> contrats = null;
       contrats= contratrepo.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10)
                )
        );
        Response res = new Response(contrats.getContent(), contrats.getTotalPages(),
                contrats.getNumber(), contrats.getSize());

        return res;
} }