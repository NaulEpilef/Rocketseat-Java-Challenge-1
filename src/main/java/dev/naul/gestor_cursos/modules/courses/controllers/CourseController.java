package dev.naul.gestor_cursos.modules.courses.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.naul.gestor_cursos.modules.courses.dto.UpdateCourseRequestDTO;
import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;
import dev.naul.gestor_cursos.modules.courses.useCases.CreateCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.DeleteCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.ListCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.ToggleCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ToggleCourseUseCase toggleCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var course = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> list() {
        try {
            var listCourse = this.listCourseUseCase.execute();
            return ResponseEntity.ok().body(listCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody UpdateCourseRequestDTO updateCourse) {
        try {
            var updatedCourse = this.updateCourseUseCase.execute(id, updateCourse);
            return ResponseEntity.ok().body(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            var message = this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleActive(@PathVariable String id) {
        try {
            var course = this.toggleCourseUseCase.execute(id);
            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
