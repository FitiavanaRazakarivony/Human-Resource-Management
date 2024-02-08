package com.example.GESTION.RH.service;

import com.example.GESTION.RH.model.Employes;
import com.example.GESTION.RH.repository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:8081")
public class EmployeService {

    @Autowired
    private EmployesRepository employesRepository;
    @PostMapping("/add")
    public Employes saveEmploye(@RequestBody Employes employee) {
        return employesRepository.save(employee);
    }
    @GetMapping("/all")
    public List<Employes> getAllEmployees() {
        return employesRepository.findAll();
    }
    // Delete employee by ID
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employesRepository.deleteById(id);
    }
    // Update employee by ID
    @PutMapping("/update/{id}")
    public Employes updateEmployee(@PathVariable Long id, @RequestBody Employes updatedEmployee) {
        return employesRepository.findById(id)
                .map(employee -> {
                    employee.setDepartement(updatedEmployee.getDepartement());
                    employee.setNom(updatedEmployee.getNom());
                    employee.setPrenom(updatedEmployee.getPrenom());
                    employee.setDate_nais(updatedEmployee.getDate_nais());
                    employee.setAdresse(updatedEmployee.getAdresse());
                    employee.setTel(updatedEmployee.getTel());
                    employee.setEmail(updatedEmployee.getEmail());
                    return employesRepository.save(employee);
                })
                .orElseGet(() -> {
                    updatedEmployee.setId(id);
                    return employesRepository.save(updatedEmployee);
                });
    }


    public Optional<Employes> getEmployeeById(Long employeeId) {
        return employesRepository.findById(employeeId);
    }

    @Service
    public static class EmailService {

        @Autowired
        private JavaMailSender javaMailSender;

        public void sendEmail(String to, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);
        }
    }
}
