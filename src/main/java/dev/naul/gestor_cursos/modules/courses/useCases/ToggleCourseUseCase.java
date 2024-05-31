package dev.naul.gestor_cursos.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;
import dev.naul.gestor_cursos.modules.courses.repositories.CourseRepository;

@Service
public class ToggleCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(String id) throws Exception {
        var uuid = UUID.fromString(id);

        var course = this.courseRepository.findById(uuid)
                .orElseThrow(() -> new Exception("O curso não foi encontrado"));

        course.setActive(!course.getActive());

        this.courseRepository.save(course);

        return course;
    }
}
