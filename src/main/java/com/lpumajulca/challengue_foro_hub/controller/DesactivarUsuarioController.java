package com.lpumajulca.challengue_foro_hub.controller;

import com.lpumajulca.challengue_foro_hub.domain.usuario.RegistrarUsuarioDto;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class DesactivarUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @DeleteMapping("/{id}/desactivar")
    public ResponseEntity<?> desactivarUsuario(@PathVariable Long id) {
        try {
            RegistrarUsuarioDto respuesta = usuarioService.desactivarUser(id);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
