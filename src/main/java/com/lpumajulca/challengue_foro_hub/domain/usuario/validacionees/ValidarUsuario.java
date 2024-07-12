package com.lpumajulca.challengue_foro_hub.domain.usuario.validacionees;

import com.lpumajulca.challengue_foro_hub.domain.usuario.RegistrarUsuarioDto;

public interface ValidarUsuario {
    public void validate(RegistrarUsuarioDto registrarUsuarioDto);
}
