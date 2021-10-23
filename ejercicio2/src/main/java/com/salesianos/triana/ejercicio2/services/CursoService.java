package com.salesianos.triana.ejercicio2.services;

import com.salesianos.triana.ejercicio2.models.Curso;
import com.salesianos.triana.ejercicio2.repositories.CursoRepository;
import com.salesianos.triana.ejercicio2.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends BaseService<Curso, Long, CursoRepository> {
}
