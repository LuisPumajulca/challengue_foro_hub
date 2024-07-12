package com.lpumajulca.challengue_foro_hub.controller;

import com.lpumajulca.challengue_foro_hub.domain.usuario.RegistrarUsuarioDto;
import com.lpumajulca.challengue_foro_hub.domain.usuario.RespuestaUsuarioDto;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioRepository;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid RegistrarUsuarioDto registroUsuarioDto, UriComponentsBuilder uriComponentsBuilder) {
        try {
            RegistrarUsuarioDto usuario = usuarioService.registrarUsuario(registroUsuarioDto);
            RespuestaUsuarioDto respuestaUsuarioDto = new RespuestaUsuarioDto(usuario.getId(), usuario.getName());
            URI url = uriComponentsBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(url).body(respuestaUsuarioDto);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.badRequest().body("Validation failed: " + ex.getMessage());
        }
    }
}
