// src/main/java/com/transport/Transport_Train/dto/RegisterRequest.java
package com.transport.Transport_Train.dto;

public class RegisterRequest {
    private String email;
    private String motDePasse;
    private String nom;
    private String prenom;

    public void setEmail(String email) { this.email = email; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    // Getters
    public String getEmail() { return email; }
    public String getMotDePasse() { return motDePasse; }  // ← M majuscule
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }

    // Setters

}