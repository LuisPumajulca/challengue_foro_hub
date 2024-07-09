package com.lpumajulca.challengue_foro_hub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record ActualizarUsuarioDto(
        @NotNull
        Long id,
        String name,
        String email
) {
}
