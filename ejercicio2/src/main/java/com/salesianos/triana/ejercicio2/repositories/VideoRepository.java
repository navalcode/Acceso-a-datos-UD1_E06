package com.salesianos.triana.ejercicio2.repositories;


import com.salesianos.triana.ejercicio2.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
