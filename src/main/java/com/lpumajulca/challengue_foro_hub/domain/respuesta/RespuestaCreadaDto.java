package com.lpumajulca.challengue_foro_hub.domain.respuesta;

import java.time.LocalDateTime;

public record RespuestaCreadaDto(
        Long id,
        String solution,
        Long usuario_Id,
        Long topico_Id,
        LocalDateTime creationDate
) {
    public RespuestaCreadaDto(Respuesta rVerified) {
        this(rVerified.getId(),rVerified.getSolution(),rVerified.getAuthor().getId(),rVerified.getTopico().getId(),rVerified.getCreationDate());
    }
}
