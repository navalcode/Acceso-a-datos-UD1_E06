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
public class Curso implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", foreignKey = @ForeignKey(name = "FK_CURSO_PROFESOR"))
    private Profesor profesor;

    @Builder.Default
    @OneToMany(mappedBy="curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();

    //Helpers Video
    public void addVideo(Video v) {
        v.setCurso(this);
        this.videos.add(v);
    }


    public void removeVideo(Video v) {
        this.videos.remove(v);
        v.setCurso(null);
    }

    //Helpers Profesor
    public void addProfesor(Profesor p) {
        this.profesor = p;
        p.getCursos().add(this);
    }

    public void removeProfesor(Profesor p) {
        p.getCursos().remove(this);
        this.profesor = null;
    }
}
