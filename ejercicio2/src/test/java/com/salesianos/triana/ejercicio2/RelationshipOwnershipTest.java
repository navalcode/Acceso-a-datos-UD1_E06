package com.salesianos.triana.ejercicio2;
import com.salesianos.triana.ejercicio2.models.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RelationshipOwnershipTest {
    @Test void movingAVideoDetachesThePreviousCourse() {
        Video video = new Video(); Curso first = new Curso(); Curso second = new Curso();
        first.addVideo(video); second.addVideo(video);
        assertTrue(first.getVideos().isEmpty()); assertEquals(1, second.getVideos().size()); assertSame(second, video.getCurso());
    }
    @Test void movingACourseDetachesThePreviousTeacher() {
        Curso course = new Curso(); Profesor first = new Profesor(); Profesor second = new Profesor();
        course.addProfesor(first); course.addProfesor(second);
        assertTrue(first.getCursos().isEmpty()); assertEquals(1, second.getCursos().size()); assertSame(second, course.getProfesor());
    }
    @Test void repeatedAttachmentsDoNotDuplicateEitherCollection() {
        Video video = new Video(); Curso course = new Curso(); Profesor teacher = new Profesor();
        course.addVideo(video); course.addVideo(video); course.addProfesor(teacher); course.addProfesor(teacher);
        assertEquals(1, course.getVideos().size()); assertEquals(1, teacher.getCursos().size());
    }
    @Test void removalFromAnotherOwnerDoesNotBreakCurrentRelationships() {
        Video video = new Video(); Curso course = new Curso(); Curso other = new Curso(); Profesor teacher = new Profesor();
        course.addVideo(video); course.addProfesor(teacher); other.removeVideo(video); course.removeProfesor(new Profesor());
        assertSame(course, video.getCurso()); assertSame(teacher, course.getProfesor());
        course.removeVideo(video); course.removeVideo(video); course.removeProfesor(teacher); course.removeProfesor(teacher);
        assertNull(video.getCurso()); assertNull(course.getProfesor());
        assertTrue(course.getVideos().isEmpty()); assertTrue(teacher.getCursos().isEmpty());
    }
}
