package com.salesianos.triana.ejercicio2.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Profesor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private double puntuacion;

    @Builder.Default
    @OneToMany(mappedBy = "profesor")
    private List<Curso> cursos = new ArrayList<>();
}
