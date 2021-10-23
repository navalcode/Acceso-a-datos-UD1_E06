package com.salesianos.triana.ejercicio1;

import com.salesianos.triana.ejercicio1.models.Categoria;
import com.salesianos.triana.ejercicio1.models.Producto;
import com.salesianos.triana.ejercicio1.services.CategoriaService;
import com.salesianos.triana.ejercicio1.services.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class MainPrueba {
    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @PostConstruct
    public void test() {
        Producto producto1 = new Producto("Manzana", 2.50);

        productoService.save(producto1);

        Categoria comida = Categoria.builder()
                .nombre("Comida")
                .build();
        categoriaService.save(comida);

        Categoria fruta = Categoria.builder()
                .nombre("Fruta")
                .build();
        categoriaService.save(fruta);

        producto1.addCategoria(fruta);
        productoService.edit(producto1);
        categoriaService.findById(comida.getId()).get().addSubcategoriaToCategoria(fruta);

    }
}
