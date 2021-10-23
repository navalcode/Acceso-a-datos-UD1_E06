package com.salesianos.triana.ejercicio1.services;

import com.salesianos.triana.ejercicio1.models.Categoria;
import com.salesianos.triana.ejercicio1.repositories.CategoriaRepository;
import com.salesianos.triana.ejercicio1.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository> {
}
