// AuthService.java
package com.transport.Transport_Train.service;

import com.transport.Transport_Train.Respitory.PassagerRespitory;
import com.transport.Transport_Train.entites.Passager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private PassagerRespitory passagerRespitory;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(String email, String MotDePasse, String nom, String prenom) {
        // Vérifie si l'email existe
        if (passagerRespitory.findByEmail(email) != null) {
            return "email déjà utilisé";
        }

        // Validation mot de passe
        if (MotDePasse == null || MotDePasse.trim().isEmpty()) {
            return "mot de passe requis";
        }

        Passager passager = new Passager();
        passager.setEmail(email);
        passager.setMotDePasse(MotDePasse);
        passager.setNom(nom);
        passager.setPrenom(prenom);

        String token = UUID.randomUUID().toString();
        passager.setVerificationToken(token);
        passager.setVerified(false);

        passagerRespitory.save(passager);
        emailService.sendVerficationEmail(email, token);

        return token; // RENVOIE LE TOKEN AU FRONTEND
    }

    public String verifyAccount(String token) {
        Passager passager = passagerRespitory.findByVerificationToken(token);
        if (passager == null) {
            return "token invalide";
        }
        passager.setVerified(true);
        passager.setVerificationToken(null);
        passagerRespitory.save(passager);
        return "votre compte a été vérifié avec succès";
    }
}