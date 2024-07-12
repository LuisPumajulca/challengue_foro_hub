package com.lpumajulca.challengue_foro_hub.domain.topico;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
public record TopicoDto(
        @NotNull(message = "El título no se puede repetir.")
        String title,
        @NotNull(message = "Utilice un lenguaje apropiado en el mensaje que no supere los 700 caracteres de longitud.")
        String message,
        @NotNull(message = "Seleccione uno de los Estados ´ACTIVO´ o ´INACTIVO´")
        Estado status,
        @NotNull(message = "Utilice su ID de autor de usuario_Id")
        Long usuario_Id,
        @NotNull(message = "Recuerda utilizar el curso apropiado para tu publicación.")
        String curso,
        LocalDateTime date
) {
}
