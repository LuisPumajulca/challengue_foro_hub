package com.lpumajulca.challengue_foro_hub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaActualizadaDto(
        @NotNull Long id,
        String solution,
        @NotNull Long usuario_Id,
        @NotNull Long topico_Id,
        LocalDateTime creationDate
) {
}
