package com.salesianos.triana.ejercicio1.services;

import com.salesianos.triana.ejercicio1.models.Producto;
import com.salesianos.triana.ejercicio1.repositories.ProductoRepository;
import org.springframework.stereotype.Service;
import com.salesianos.triana.ejercicio1.services.base.BaseService;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
}
