package com.lpumajulca.challengue_foro_hub.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Page<Usuario> findByActiveTrue(Pageable pageable);
    UserDetails findByEmail(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
