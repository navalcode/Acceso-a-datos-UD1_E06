package com.salesianos.triana.ejercicio1.repositories;

import com.salesianos.triana.ejercicio1.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
