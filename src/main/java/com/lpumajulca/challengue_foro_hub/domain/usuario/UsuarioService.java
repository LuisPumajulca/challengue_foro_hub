package com.lpumajulca.challengue_foro_hub.domain.usuario;

import com.lpumajulca.challengue_foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public RegistrarUsuarioDto registrarUsuario(RegistrarUsuarioDto registroUsuarioDTO) {

        if (usuarioRepository.existsByEmail(registroUsuarioDTO.email())) {
            throw new ValidacionDeIntegridad("Este correo electrónico ya está registrado.");
        }

        if (usuarioRepository.existsByUsername(registroUsuarioDTO.username())) {
            throw new ValidacionDeIntegridad("Este nombre de usuario ya está en uso.");
        }

        var usuario = new Usuario(registroUsuarioDTO, passwordEncoder);
        usuarioRepository.save(usuario);
        return new RegistrarUsuarioDto(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
    public RegistrarUsuarioDto actualizacionUsuario(Long id, ActualizarUsuarioDto actualizacionUsuarioDTO) {
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("El usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        usuarioRepository.save(usuario);
        return new RegistrarUsuarioDto(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
    public RegistrarUsuarioDto desactivarUser(Long id) {
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("El usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        usuario.deactivateUser();

        usuarioRepository.save(usuario);
        return new RegistrarUsuarioDto(
                usuario.getId(),
                usuario.getName(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
}
