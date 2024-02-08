package com.example.GESTION.RH.model;

import javax.persistence.*;

@Entity
public class Employes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_employe")
    private Long id;
    @Column (name = "departement")
    private String dep;
    @Column (name = "nom")
    private String nom;

    @Column (name = "prenom")
    private String prenom;

    @Column (name = "date_naissance")
    private String date_nais;
    @Column (name = "adresse")
    private String adresse;

    @Column (name = "telephone")
    private String tel;
    @Column (name = "email")
    private String email;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartement() {
        return dep;
    }

    public void setDepartement(String departement) {
        this.dep = departement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_nais() {
        return date_nais;
    }

    public void setDate_nais(String date_nais) {
        this.date_nais = date_nais;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
