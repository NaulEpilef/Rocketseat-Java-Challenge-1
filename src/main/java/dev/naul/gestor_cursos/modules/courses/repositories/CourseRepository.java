package dev.naul.gestor_cursos.modules.courses.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.naul.gestor_cursos.modules.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    public Optional<List<CourseEntity>> findByNameContainingAndCategoryContaining(String name, String category);
}
