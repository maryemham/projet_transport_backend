package com.transport.Transport_Train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendVerficationEmail(String to,String token){
        String subject ="Vérification de votre compte";
        String url="http://localhost:8080/api/auth/verify?token="+token;
        String message ="Bonjour,\n\n"
                +"Merci de créer un compte . Cliquez sur le lien ci dessous pour activer votre compte : \n"
                +url+"\n\n"
                +"si vous n'etes pas l'auteur de cette delande , ignorez cet e-mail";
        SimpleMailMessage email=new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
    }
}
