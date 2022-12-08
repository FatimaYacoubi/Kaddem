package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Offre;
import com.example.springsecurity.Entity.Partenaire;
import com.example.springsecurity.Repository.OffreRepository;
import com.example.springsecurity.Repository.PartenaireRepository;
import com.example.springsecurity.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.model.MailRequest;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class OffreServiceImp implements IoffreService{

    OffreRepository offreRepository;
    PartenaireRepository partenaireRepository;
 UniversiteRepository universiteRepository;
    EmailService emailService;
    JavaMailSender emailSender;



    public Long ajouterOffre(Offre o ) {

        offreRepository.save(o);
        log.info("Ajouter Offre");

        MailRequest mailRequest = new MailRequest("Esprit",
                "zeineb.hamdi@esprit.tn", "Nouvelle Offre", "Notre entreprise, implantée à Tunis, est spécialisée dans le secteur des secteurs d’activité depuis  2015 années.\n" +
                "Nos services ont par conséquent pu acquérir l’expérience et la compétence pour étudier, planifier, estimer le budget nécessaire à de telles opérations et ainsi vous transmettre un devis en 48 heures. \n"
                ,"S'inscrire Maintenant", "http://localhost:4200" );

            emailService.sendEmail(mailRequest);



            return o.getIdOffre();
    }
    @Override
    public Iterable<Offre> retrieveAllOffre() {return offreRepository.findAll();}


    @Override
    public void deleteOffre(Long id) {
        offreRepository.deleteById(id);}

    @Override
    public Offre updateOffre(Offre o) {return offreRepository.save(o);}

    @Override
    public Offre retrieveOffre(Long idOffre) {
        return offreRepository.findById(idOffre).get();
    }


    @Override
    public void assignOffreToPartenaire( Long idOffre , Long idPar) {

        Offre offre = offreRepository.findById(idOffre).orElse(null);
        Partenaire partenaire = partenaireRepository.findById(idPar).orElse(null);
        offre.setListpartenaire(partenaire);
        offreRepository.save(offre);
    }


    /**public void sendSimpleEmail(String to,String descriptionOffre) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Nouveau Offre ");
        message.setText("Bonjour Mr "+to +" Nouveau Offre: "+descriptionOffre);

        // Send Message!
        this.emailSender.send(message);

    }*/




}
