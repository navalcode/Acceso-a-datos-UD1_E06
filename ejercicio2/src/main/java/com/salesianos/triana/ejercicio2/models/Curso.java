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

    // Relationship helpers keep both sides aligned when ownership changes.
    public void addVideo(Video video) {
        java.util.Objects.requireNonNull(video, "video");
        if (video.getCurso() != null && video.getCurso() != this) {
            video.getCurso().getVideos().remove(video);
        }
        video.setCurso(this);
        if (!this.videos.contains(video)) this.videos.add(video);
    }

    public void removeVideo(Video video) {
        if (video == null || video.getCurso() != this) return;
        this.videos.remove(video);
        video.setCurso(null);
    }

    public void addProfesor(Profesor teacher) {
        java.util.Objects.requireNonNull(teacher, "teacher");
        if (this.profesor != null && this.profesor != teacher) {
            this.profesor.getCursos().remove(this);
        }
        this.profesor = teacher;
        if (!teacher.getCursos().contains(this)) teacher.getCursos().add(this);
    }

    public void removeProfesor(Profesor teacher) {
        if (teacher == null || this.profesor != teacher) return;
        teacher.getCursos().remove(this);
        this.profesor = null;
    }
}
