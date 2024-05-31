package dev.naul.gestor_cursos.modules.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseRequestDTO {

    private String name;
    private String category;
}
