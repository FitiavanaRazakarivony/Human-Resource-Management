package com.example.GESTION.RH.application;
import com.example.GESTION.RH.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    @Override
    public void run(String... args) {
        // Envoyer un e-mail
        emailService.sendEmail("fitiavanarazakarivony00@gmail.com", "Test Subject", "Hello, this is a test email!");
    }
}