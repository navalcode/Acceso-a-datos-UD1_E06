package com.salesianos.triana.ejercicio1.repositories;

import com.salesianos.triana.ejercicio1.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
