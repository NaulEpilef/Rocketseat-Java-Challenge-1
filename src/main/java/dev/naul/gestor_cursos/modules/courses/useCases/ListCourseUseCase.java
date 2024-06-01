package dev.naul.gestor_cursos.modules.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.naul.gestor_cursos.modules.courses.dto.ListCourseRequestDTO;
import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;
import dev.naul.gestor_cursos.modules.courses.repositories.CourseRepository;

@Service
public class ListCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(ListCourseRequestDTO listCourseRequestDTO) throws Exception {
        var courses = this.courseRepository
                .findByNameContainingAndCategoryContaining(listCourseRequestDTO.getName(),
                        listCourseRequestDTO.getCategory())
                .orElseThrow(() -> new Exception("Nada foi retornado"));

        return courses;
    }
}
