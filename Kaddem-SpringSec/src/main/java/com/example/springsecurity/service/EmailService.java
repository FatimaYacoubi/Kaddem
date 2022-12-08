package com.example.springsecurity.service;

import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.TemplateException;
import tn.esprit.spring.model.MailRequest;
import tn.esprit.spring.model.MailResponse;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private Configuration config;



    public static boolean between(int variable, int minValueInclusive, int maxValueInclusive) {
        return variable >= minValueInclusive && variable <= maxValueInclusive;
    }



    public MailResponse sendEmail(MailRequest mailRequest) {
        MailResponse response = new MailResponse();
        MimeMessage message = sender.createMimeMessage();
        try {
            // set mediaType
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            // add attachment

            Template t = config.getTemplate("email-template.ftl");
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("name", mailRequest.getName());
            model.put("body", mailRequest.getBody());
           // model.put("bonjourOrBonsoir", Utils.GetMessageBonsoirOrBonjour());
            model.put("buttonTitle", mailRequest.getButtonTitle());
            model.put("buttonHref", mailRequest.getButtonHref());

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setTo(mailRequest.getTo());
            helper.setText(html, true);
            helper.setSubject(mailRequest.getSubject());
            helper.addInline("1.png",  new ClassPathResource("1.png"));
            helper.addInline("2.png",  new ClassPathResource("2.png"));
            helper.addInline("3.png",  new ClassPathResource("3.png"));
            helper.addInline("4.png",  new ClassPathResource("4.png"));
            helper.addInline("5.jpg",  new ClassPathResource("img-01.jpg"));
            helper.addInline("6.png",  new ClassPathResource("logo.png"));

            sender.send(message);

            response.setMessage("mail send to : "+mailRequest.getTo() );
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException  e) {
            response.setMessage("Mail Sending failure : " + e.getMessage());
            response.setStatus(Boolean.FALSE);
        }
        catch (IOException  e) {
            response.setMessage("Mail Sending failure : " + e.getMessage());
            response.setStatus(Boolean.FALSE);
        }
        catch ( TemplateException e) {
            response.setMessage("Mail Sending failure : " + e.getMessage());
            response.setStatus(Boolean.FALSE);
        }

        return response;
    }











    /**public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Universite universite) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Welcome To SpringHow.com");
        helper.setTo(universite.getEmail());
        String emailContent = getEmailContent(universite);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    String getEmailContent(Universite universite) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("universite", universite);
        configuration.getTemplate("email-template.ftl").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }*/
}