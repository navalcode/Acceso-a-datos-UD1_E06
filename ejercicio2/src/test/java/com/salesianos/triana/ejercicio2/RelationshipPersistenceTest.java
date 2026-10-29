package com.salesianos.triana.ejercicio2;
import com.salesianos.triana.ejercicio2.models.*;
import com.salesianos.triana.ejercicio2.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest(properties={"spring.sql.init.mode=never","spring.jpa.hibernate.ddl-auto=create-drop"})
class RelationshipPersistenceTest {
    @Autowired CursoRepository courses;
    @Autowired ProfesorRepository teachers;
    @Autowired VideoRepository videos;
    @Autowired EntityManager entities;
    @Test void videoTransferSurvivesAFlushAndReload() {
        Curso first=courses.save(new Curso()); Curso second=courses.save(new Curso()); Video video=new Video();
        first.addVideo(video); courses.saveAndFlush(first); video=first.getVideos().get(0); assertNotNull(video.getId()); Long videoId=video.getId(); Long secondId=second.getId();
        second.addVideo(video); courses.saveAndFlush(second); entities.clear();
        assertEquals(secondId,videos.findById(videoId).orElseThrow().getCurso().getId());
        assertTrue(courses.findById(first.getId()).orElseThrow().getVideos().isEmpty());
    }
    @Test void teacherTransferIsVisibleFromBothReloadedCollections() {
        Profesor first=teachers.save(new Profesor()); Profesor second=teachers.save(new Profesor()); Curso course=new Curso();
        course.addProfesor(first); courses.saveAndFlush(course); course.addProfesor(second); courses.saveAndFlush(course); entities.clear();
        assertTrue(teachers.findById(first.getId()).orElseThrow().getCursos().isEmpty());
        assertEquals(1,teachers.findById(second.getId()).orElseThrow().getCursos().size());
    }
    @Test void removingAVideoStillDeletesTheOrphanAndKeepsTheCourse() {
        Curso course=courses.save(new Curso()); Video video=new Video(); course.addVideo(video); courses.saveAndFlush(course);
        video=course.getVideos().get(0); assertNotNull(video.getId()); Long videoId=video.getId(); course.removeVideo(video); courses.saveAndFlush(course); entities.clear();
        assertTrue(courses.existsById(course.getId())); assertFalse(videos.existsById(videoId));
    }
}
