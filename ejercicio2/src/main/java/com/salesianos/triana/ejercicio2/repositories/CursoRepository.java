package com.salesianos.triana.ejercicio2.repositories;

import com.salesianos.triana.ejercicio2.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
