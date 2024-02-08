package com.example.GESTION.RH.service;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {

    private Set<String> usedCodes = new HashSet<>();

    public String generateVerificationCode() {
        // Définir la longueur du code de vérification
        int codeLength = 6;

        // Caractères autorisés dans le code de vérification
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // Initialiser le générateur de nombres aléatoires sécurisé
        Random random = new SecureRandom();

        // Créer une chaîne pour stocker le code de vérification
        StringBuilder verificationCode = new StringBuilder(codeLength);

        // Générer le code de vérification caractère par caractère
        for (int i = 0; i < codeLength; i++) {
            verificationCode.append(characters.charAt(random.nextInt(characters.length())));
        }

        // Ajouter le code à la liste des codes utilisés
        usedCodes.add(verificationCode.toString());

        // Retourner le code de vérification généré
        System.out.println("code email 11111111"+" "+ verificationCode);

        return verificationCode.toString();
    }

    public boolean verifyCode(String code) {
        boolean isValid = usedCodes.contains(code);
        System.out.println("code"+code);

        if (isValid) {
            usedCodes.remove(code);
            System.out.println("code isValid"+isValid);

        }

        return isValid;
    }
    // Autres méthodes liées à la vérification de l'e-mail, si nécessaire
}

