package dev.naul.gestor_cursos.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.naul.gestor_cursos.modules.courses.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public String execute(String id) throws Exception {
        var uuid = UUID.fromString(id);

        var course = this.courseRepository.findById(uuid)
                .orElseThrow(() -> new Exception("O curso não foi encontrado"));

        this.courseRepository.deleteById(uuid);

        return "O curso '" + course.getName() + "' foi excluído";
    }
}
