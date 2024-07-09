package com.lpumajulca.challengue_foro_hub.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException{
    public ValidacionDeIntegridad(String message) {
        super(message);
    }
}
