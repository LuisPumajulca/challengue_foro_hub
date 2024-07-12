package com.lpumajulca.challengue_foro_hub.domain.usuario;

public record ListarUsuarioDto(
        Long id,
        String name,
        String email
) {
    public ListarUsuarioDto(Usuario usuario){
        this(usuario.getId(),usuario.getName(),usuario.getEmail());
    }
}
