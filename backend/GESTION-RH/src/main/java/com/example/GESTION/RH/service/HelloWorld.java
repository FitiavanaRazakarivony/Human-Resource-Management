package com.example.GESTION.RH.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:8082")
@RestController
public class HelloWorld {
    @GetMapping("/sa")
    public String hello(){
        return "Hello,!";
    }
}
