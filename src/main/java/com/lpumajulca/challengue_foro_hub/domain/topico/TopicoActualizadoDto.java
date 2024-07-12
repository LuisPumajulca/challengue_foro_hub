package com.lpumajulca.challengue_foro_hub.domain.topico;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
public record TopicoActualizadoDto(
        @NotNull Long id,
        String title,
        String message,
        Estado status,
        @NotNull Long usuario_Id,
        String curso,
        LocalDateTime date
) {
}
