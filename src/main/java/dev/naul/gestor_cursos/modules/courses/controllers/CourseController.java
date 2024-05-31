package dev.naul.gestor_cursos.modules.courses.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.naul.gestor_cursos.modules.courses.dto.UpdateCourseRequestDTO;
import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;
import dev.naul.gestor_cursos.modules.courses.useCases.CreateCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.ListCourseUseCase;
import dev.naul.gestor_cursos.modules.courses.useCases.UpdateCourseUseCase;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity) {
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
}
