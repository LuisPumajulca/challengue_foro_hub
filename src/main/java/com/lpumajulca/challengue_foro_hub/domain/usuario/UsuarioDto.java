package com.lpumajulca.challengue_foro_hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
        @NotBlank(message = "Utilice su correo electrónico como nombre de usuario")
        @Email(message = "Correo electrónico inválido.")
        String email,
        @NotBlank(message = "Debe tener entre 10 y 15 caracteres.")
        String password
) {

}
