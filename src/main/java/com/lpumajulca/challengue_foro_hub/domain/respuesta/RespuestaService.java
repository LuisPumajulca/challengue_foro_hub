package com.lpumajulca.challengue_foro_hub.domain.respuesta;


import com.lpumajulca.challengue_foro_hub.domain.topico.TopicoRepository;
import com.lpumajulca.challengue_foro_hub.domain.usuario.UsuarioRepository;
import com.lpumajulca.challengue_foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository repository;

    public RespuestaCreadaDto respuestaCreadaDTO(RespuestaDto respuestaDto) {
        if (!usuarioRepository.findById(respuestaDto.usuario_Id()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos. ");
        }
        if (!topicoRepository.findById(respuestaDto.topico_Id()).isPresent()){
            throw new ValidacionDeIntegridad("Este id de tópico no está registrado en la base de datos. ");
        }
        var usuario = usuarioRepository.findById(respuestaDto.usuario_Id()).get();
        var topico =topicoRepository.findById(respuestaDto.topico_Id()).get();

        var rVerified= new Respuesta(null,respuestaDto.solution(),usuario,topico,respuestaDto.creationDate());
        repository.save(rVerified);
        return new RespuestaCreadaDto(rVerified);
    }
}
