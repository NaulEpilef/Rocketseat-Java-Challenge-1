package dev.naul.gestor_cursos.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.naul.gestor_cursos.modules.courses.dto.UpdateCourseRequestDTO;
import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;
import dev.naul.gestor_cursos.modules.courses.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(String id, UpdateCourseRequestDTO updateCourse) throws Exception {
        var uuid = UUID.fromString(id);
        var course = this.courseRepository.findById(uuid)
                .orElseThrow(() -> new Exception("Curso não encontrado"));

        if (updateCourse.getName() != null)
            course.setName(updateCourse.getName());
        if (updateCourse.getCategory() != null)
            course.setCategory(updateCourse.getCategory());

        var updatedCourse = this.courseRepository.save(course);

        return updatedCourse;
    }
}
