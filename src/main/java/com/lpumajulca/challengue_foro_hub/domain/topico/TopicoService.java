package com.lpumajulca.challengue_foro_hub.domain.topico;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioRepository;
import com.lpumajulca.challengue_foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public RespuestaTopicoDto topicoCreado(TopicoDto topicoDto){
        if (!usuarioRepository.findById(topicoDto.usuario_Id()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos.");
        }
        var title= topicoDto.title();
        if (title != null && topicoRepository.existsByTitleIgnoreCase(title)){
            throw new ValidacionDeIntegridad("Este título ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        String message = topicoDto.message();
        if (message != null && topicoRepository.existsByMessageIgnoreCase(message)){
            throw new ValidacionDeIntegridad("Este mensaje ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        var usuario = usuarioRepository.findById(topicoDto.usuario_Id()).get();
        var topicoId= new Topico(null,title,message,topicoDto.date(),topicoDto.status(),usuario,topicoDto.curso());
        topicoRepository.save(topicoId);
        return new RespuestaTopicoDto(topicoId);
    }
}
