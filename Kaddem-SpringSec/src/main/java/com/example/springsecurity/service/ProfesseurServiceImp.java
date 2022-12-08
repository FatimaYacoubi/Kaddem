package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Departement;
import com.example.springsecurity.Entity.Professeur;
import com.example.springsecurity.Repository.DepartementRepository;
import com.example.springsecurity.Repository.ProfesseurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProfesseurServiceImp implements IProfesseurService {

  @Autowired
  ProfesseurRepository professeurRepository;
  @Autowired
  DepartementRepository departementRepository;
  @Autowired
  private JavaMailSender javaMailSender;

    @Override
    public Long ajouter_professeur(Professeur p) {
        professeurRepository.save(p);
        log.info("Ajouter Professeur");
       sendSimpleEmail("zeinebhamdi2013@gmail.com");
      return p.getIdProfesseur();
    }

    @Override
    public Iterable<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @Override
    public void deleteProfesseur(long id) {
         professeurRepository.deleteById(id);
    }




    public Optional<Professeur> findProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }

    @Override
    public float calculSalaire(float prixHeure, Long id) {
        float s =0;
        return  s= prixHeure*getnbHeureById(id);
    }

    public int getnbHeureById(Long id) {

        return professeurRepository.findById(id).get().getNbrheure();
    }
/*
    public LocalDate getCurrentTimeUsingCalendar() {
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);
        return date;
    }

    public float CalculSalaireWithDate(float prixHeure, Long id)
    {

        Date dateDebut = professeurRepository.findById(id).get().getAnneeAmb();
        LocalDate Today = getCurrentTimeUsingCalendar();
        float a = dateDebut.getMonth();
        int monthes = Months
       // b=  Today.getMonth();
        float s =0;
        return  s= a*prixHeure;

    }

 */
@Value("${spring.mail.username}") private String sender;


    public String sendSimpleEmail(String to) {

       // Try block to check for exceptions
       try {

           // Creating a simple mail message
           SimpleMailMessage mailMessage
                   = new SimpleMailMessage();

           mailMessage.setFrom(sender);
           System.out.println(sender);
           mailMessage.setTo(to);

           mailMessage.setText("heygirl");

           mailMessage.setSubject("girlbye");
           System.out.println("didn't yet");

           // Sending the mail
           javaMailSender.send(mailMessage);
           System.out.println("baatht");

       }
       // Catch block to handle the exceptions
       catch (Exception e) {
           return "Error while Sending Mail";
       }

        return to;
    }

    public List<Professeur> search(String rech) {
        if (rech != null) {
            return professeurRepository.search(rech);
        }
        return professeurRepository.findAll();
    }

    @Override
    public void assignProfesseurToDepartement(Long ProfID, Long departeId) {

        Professeur professeur =professeurRepository.findById(ProfID).orElse(null);
        Departement departement = departementRepository.findById(departeId).orElse(null);
        professeur.setDepartementsProf(departement);
        professeurRepository.save(professeur);
    }

}