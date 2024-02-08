package com.example.GESTION.RH;

import com.example.GESTION.RH.model.Employes;
import com.example.GESTION.RH.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import java.util.Optional;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.GESTION.RH")
public class GestionRH implements CommandLineRunner {

    private EmployeService employeService;
    private EmployeService.EmailService emailService;

    @Autowired
    public GestionRH(EmployeService employeService, EmployeService.EmailService emailService) {
        this.employeService = employeService;
        this.emailService = emailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionRH.class, args);
    }

    @Override
    public void run(String... args) {

////        Ajout
//        // Utilisez le employeService pour interagir avec la table des employés
//        Employes employe = new Employes();
//
//        employe.setDepartement("Sample Department");
//        employe.setNom("Frede");
//        employe.setPrenom("Deo");
//        employe.setDate_nais("1990-01-01");
//        employe.setAdresse("123 Sample Street");
//        employe.setTel("123456789");
//        employe.setEmail("john.doe@example.com");
//        employeService.saveEmploye(employe);
////        /********** FIN DU Ajout *********/

//            LISTE

        System.out.println("Liste des employés :");
        Iterable<Employes> allEmployees = employeService.getAllEmployees();
        allEmployees.forEach(employee -> {
            System.out.println("ID : " + employee.getId());
            System.out.println("Nom : " + employee.getNom());
            // ... Affichez d'autres propriétés selon vos besoins
        });
//        /********** FIN DU LISTE *********/


////            DELETE
//        Long employeeIdToDelete = 35L; // Remplacez cela par l'ID de l'employé que vous souhaitez supprimer
//        employeService.deleteEmployee(employeeIdToDelete);
//        System.out.println("Employé avec l'ID " + employeeIdToDelete + " supprimé avec succès.");
//
////        /********** FIN DE DELETE *********/


//        MODIFICATION
        // Récupérer l'employé que vous souhaitez mettre à jour (par exemple, avec l'ID 1)
//        Long employeeIdToUpdate = 40L;
//        Optional<Employes> employeeToUpdateOptional = employeService.getEmployeeById(employeeIdToUpdate);
//
//        // Vérifiez si l'employé existe
//        if (employeeToUpdateOptional.isPresent()) {
//            Employes employeeToUpdate = employeeToUpdateOptional.get();
//
//            // Effectuez les modifications nécessaires
//            employeeToUpdate.setDepartement("département");
//            employeeToUpdate.setNom("Ta");
//            // ... Mettez à jour d'autres propriétés selon vos besoins
//
//            // Utilisez employeService pour effectuer la mise à jour
//            Employes updatedEmployee = employeService.updateEmployee(employeeIdToUpdate, employeeToUpdate);
//
//            // Affichez les détails de l'employé mis à jour
//            System.out.println("Employé mis à jour :");
//            System.out.println("ID : " + updatedEmployee.getId());
//            System.out.println("Nom : " + updatedEmployee.getNom());
//
//            // ... Affichez d'autres propriétés selon vos besoins
//
//           // Envoyer un e-mail après la mise à jour
//      //     String recipientEmail = "fitianarazakarivony00@gmail.com";
//       //      String emailSubject = "Mise à jour d'employé";
//      //      String emailBody = "L'employé avec l'ID " + updatedEmployee.getId() + " a été mis à jour.";
//
//        //    emailService.sendEmail(recipientEmail, emailSubject, emailBody);
//        } else {
//            System.out.println("Aucun employé trouvé avec l'ID : " + employeeIdToUpdate);
//        }
////        /
// ********** FIN DE MODIFICATION *********/

            // Envoi d'e-mail après la mise à jour
            Long employeeIdToUpdate = 34L; // Remplacez cela par l'ID de l'employé que vous avez mis à jour
            Optional<Employes> employeeToUpdateOptional = employeService.getEmployeeById(employeeIdToUpdate);

            if (employeeToUpdateOptional.isPresent()) {
                Employes updatedEmployee = employeeToUpdateOptional.get();
                String recipientEmail = "fitiavanarazakarivony00@gmail.com";
                String emailSubject = "Mise à jour d'employé";
                String emailBody = "L'employé avec l'ID " + updatedEmployee.getId() + " a été mis à jour.";

                emailService.sendEmail(recipientEmail, emailSubject, emailBody);
            } else {
                System.out.println("Aucun employé trouvé avec l'ID : " + employeeIdToUpdate);
            }
        System.out.println("1");

        }

}
