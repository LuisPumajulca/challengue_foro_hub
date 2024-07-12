package com.lpumajulca.challengue_foro_hub.domain.usuario;

public record RespuestaUsuarioDto (
        Long id,
        String name
){
    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
