package com.lpumajulca.challengue_foro_hub.controller;

import com.lpumajulca.challengue_foro_hub.domain.usuario.Usuario;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioDto;
import com.lpumajulca.challengue_foro_hub.infra.security.JWTTokenDto;
import com.lpumajulca.challengue_foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity usuarioAutenticacion(@RequestBody @Valid UsuarioDto usuarioDto) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDto.email(), usuarioDto.password());
        var autenticacionUsuario = authenticationManager.authenticate(authToken);
        var token = tokenService.generarToken((Usuario) autenticacionUsuario.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDto(token));
    }

}
