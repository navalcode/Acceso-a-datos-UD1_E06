package com.salesianos.triana.ejercicio2;

import com.salesianos.triana.ejercicio2.models.Curso;
import com.salesianos.triana.ejercicio2.models.Profesor;
import com.salesianos.triana.ejercicio2.models.Video;
import com.salesianos.triana.ejercicio2.services.CursoService;
import com.salesianos.triana.ejercicio2.services.ProfesorService;
import com.salesianos.triana.ejercicio2.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class MainPrueba {

    private final CursoService cursoService;
    private final ProfesorService profesorService;
    private final VideoService videoService;

    @PostConstruct
    public void tests (){
        Profesor p1 = Profesor.builder()
                .nombre("Eufrasio")
                .email("eu_profe@gmail.com")
                .puntuacion(4.8)
                .build();

        profesorService.save(p1);

        Curso c1 = Curso.builder()
                .nombre("Escenografía")
                .puntuacion(4.5)
                .build();

        cursoService.save(c1);
        c1.addProfesor(p1);
        cursoService.edit(c1);

        Video v1 = Video.builder()
                .orden("2")
                .titulo("Maquinaria barroca")
                .descripcion("Principales recursos escenográficos utilizados durante el siglo XVIII.")
                .url("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                .build();

        videoService.save(v1);
        //En este caso al ser asociación de composición lo gestionamo desde el
        //lado propietario con cardinalidad 1, Curso.
        c1.addVideo(v1);
        cursoService.edit(c1);

    }
}
