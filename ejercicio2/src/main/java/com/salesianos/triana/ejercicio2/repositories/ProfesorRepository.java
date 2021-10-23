package com.salesianos.triana.ejercicio2.repositories;

import com.salesianos.triana.ejercicio2.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
