package com.lpumajulca.challengue_foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDto(
        @NotBlank(message = "Título es obligatorio")
        String title,
        @NotBlank(message = "Mensaje es obligatorio")
        String message,
        @NotBlank(message = "Curso es obligatorio")
        String course,
        @NotNull(message = "Author_id es obligatorio")
        Long author_id
) {
    public RegistroTopicoDto(String title, String message, String course, Long author_id){
        this.title = title;
        this.message = message;
        this.course = course;
        this.author_id = author_id;
    }
}
