package com.lpumajulca.challengue_foro_hub.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean active;

    public Usuario(RegistrarUsuarioDto registroUsuarioDTO) {
        this.name = registroUsuarioDTO.name();
        this.email = registroUsuarioDTO.email();
        this.password = registroUsuarioDTO.password();
    }
    public Usuario(RegistrarUsuarioDto registroUsuarioDTO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.name = registroUsuarioDTO.name();
        this.username = registroUsuarioDTO.username();
        this.email = registroUsuarioDTO.email();
        this.password = bCryptPasswordEncoder.encode(registroUsuarioDTO.password());
        this.active = true;
    }

    public void actualizacionUsuario(ActualizarUsuarioDto actualizacionUsuarioDTO) {
        if (actualizacionUsuarioDTO.name() != null) {
            this.name = actualizacionUsuarioDTO.name();
        }
        if (actualizacionUsuarioDTO.email() != null) {
            this.email = actualizacionUsuarioDTO.email();
        }
    }

    public void deactivateUser() {
        this.active = false;
    }
}
