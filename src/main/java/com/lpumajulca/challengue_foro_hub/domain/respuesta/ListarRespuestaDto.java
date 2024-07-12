package com.lpumajulca.challengue_foro_hub.domain.respuesta;

import java.time.LocalDateTime;

public record ListarRespuestaDto(
        Long id,
        String solution,
        Long usuario_Id,
        Long topico_Id,
        LocalDateTime creationDate
) {
    public ListarRespuestaDto(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getSolution(),
                respuesta.getAuthor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getCreationDate());
    }
}
