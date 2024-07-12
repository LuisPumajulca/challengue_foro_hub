package com.lpumajulca.challengue_foro_hub.domain.topico;

import java.time.LocalDateTime;
public record RespuestaTopicoDto(
        Long id,
        String title,
        String message,
        Estado status,
        Long usuario_Id,
        String curso,
        LocalDateTime date
) {
    public RespuestaTopicoDto(Topico topicoId) {
        this(
                topicoId.getId(),
                topicoId.getTitle(),
                topicoId.getMessage(),
                topicoId.getStatus(),
                topicoId.getAuthor().getId(),
                topicoId.getCourse(),
                topicoId.getDate());
    }
}
