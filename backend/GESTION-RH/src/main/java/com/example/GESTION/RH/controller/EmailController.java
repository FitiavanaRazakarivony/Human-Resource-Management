package com.example.GESTION.RH.controller;
import com.example.GESTION.RH.model.EmailRequest;
import com.example.GESTION.RH.service.EmailService;
import com.example.GESTION.RH.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestParam(name = "to") String to,
            @RequestParam(name = "subject") String subject,
            @RequestParam(name = "body") String body) {
        String verificationCode = emailVerificationService.generateVerificationCode();
        emailService.sendEmail(to, subject, body + "\n\n Votre code de vérification : " + verificationCode);
        return ResponseEntity.ok("Email sent successfully.");
    }
}