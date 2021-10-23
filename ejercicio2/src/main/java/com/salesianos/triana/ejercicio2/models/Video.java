package com.salesianos.triana.ejercicio2.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Video implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String orden;
    private String titulo;

    @Lob
    private String descripcion;

    @Lob
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id", foreignKey = @ForeignKey(name = "FK_VIDEO_CURSO"))
    private Curso curso;


}
