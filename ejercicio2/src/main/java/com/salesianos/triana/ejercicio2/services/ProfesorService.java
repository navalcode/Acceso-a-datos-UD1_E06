package com.salesianos.triana.ejercicio2.services;

import com.salesianos.triana.ejercicio2.models.Profesor;
import com.salesianos.triana.ejercicio2.repositories.ProfesorRepository;
import com.salesianos.triana.ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService extends BaseService<Profesor, Long, ProfesorRepository> {
}
