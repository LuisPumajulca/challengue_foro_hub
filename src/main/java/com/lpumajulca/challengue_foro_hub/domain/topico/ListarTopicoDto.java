package com.lpumajulca.challengue_foro_hub.domain.topico;

import java.time.LocalDateTime;

public record ListarTopicoDto(
        Long id,
        String title,
        String message,
        Estado status,
        Long usuario_Id,
        String curso,
        LocalDateTime date
) {
    public ListarTopicoDto (Topico topico){
        this(
                topico.getId(),
                topico.getTitle(),
                topico.getMessage(),
                topico.getStatus(),
                topico.getAuthor().getId(),
                topico.getCourse(),
                topico.getDate());

    }
}
