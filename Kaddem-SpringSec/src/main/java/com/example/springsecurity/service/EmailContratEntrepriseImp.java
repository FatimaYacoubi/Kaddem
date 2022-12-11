package com.example.springsecurity.service;

import javax.mail.MessagingException;
import java.io.File;
import javax.mail.internet.MimeMessage;

import com.example.springsecurity.Entity.EmailEntrepriseContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class EmailContratEntrepriseImp {
@Autowired
private  JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;


    @Async
    public String sendSimpleMail(EmailEntrepriseContrat details) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            System.out.println(sender);
        mailMessage.setTo(details.getRecipient());
            System.out.println(details.getRecipient());

            mailMessage.setText(details.getMsgBody());
            System.out.println(details.getMsgBody());

            mailMessage.setSubject(details.getSubject());
            System.out.println("didn't yet");

        // Sending the mail
        javaMailSender.send(mailMessage);
            System.out.println("baatht");

            return "Mail Sent Successfully...";
    }

    // Catch block to handle the exceptions
        catch (Exception e) {
        return "Error while Sending Mail";
    }
    }
    @Async

    public String sendMailWithAttachment(String to) {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText("Vous Avez Reçu une demande de contrat, Contactez nous pour plus D'informations. /n -Kaddem.");
            mimeMessageHelper.setSubject(
                   " Ceci est un contrat Dédier a vous , vous pouvez choisir de l'accepter ou le refusez! ");

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(""));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException  e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}