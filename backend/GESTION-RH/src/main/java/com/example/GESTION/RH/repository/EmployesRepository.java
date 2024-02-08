package com.example.GESTION.RH.repository;

import com.example.GESTION.RH.model.Employes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployesRepository extends JpaRepository<Employes, Long> {
}
