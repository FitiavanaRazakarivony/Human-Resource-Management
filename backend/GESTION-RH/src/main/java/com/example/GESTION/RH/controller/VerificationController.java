package com.example.GESTION.RH.controller;

import com.example.GESTION.RH.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    @Autowired
    private EmailVerificationService emailVerificationService;

    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(
            @RequestParam String code) {

        if (emailVerificationService.verifyCode(code)) {
            return ResponseEntity.ok("L'e-mail a été vérifié avec succès.");
        } else {
            return ResponseEntity.badRequest().body("Le code de vérification n'est pas valide.");
        }
    }
}
