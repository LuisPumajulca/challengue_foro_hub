package com.lpumajulca.challengue_foro_hub.controller;

import com.lpumajulca.challengue_foro_hub.domain.respuesta.*;
import com.lpumajulca.challengue_foro_hub.infra.errores.ValidacionDeIntegridad;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/respuesta")
@SecurityRequirement(name="bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @Autowired
    private RespuestaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity respuestaRegistrada (@RequestBody @Valid RespuestaDto respuestaDto) throws ValidacionDeIntegridad {
        var respuestaRegistrada = respuestaService.respuestaCreadaDTO(respuestaDto);
        return ResponseEntity.ok(respuestaRegistrada);
    }

    @GetMapping("/respuestas")
    public ResponseEntity<Page<ListarRespuestaDto>>  listarRespuestas(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(repository.findByActiveTrue(paged).map(ListarRespuestaDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity <RespuestaCreadaDto> respuestaCreada(@PathVariable Long id){
        Respuesta respuesta=repository.getReferenceById(id);
        var respuestaRegistrada = new RespuestaCreadaDto(respuesta.getId(),
                respuesta.getSolution(),
                respuesta.getAuthor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getCreationDate());
        return ResponseEntity.ok(respuestaRegistrada);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity respuestaActualizada(@RequestBody @Valid RespuestaActualizadaDto respuestaActualizadaDTO){
        Respuesta respuesta=repository.getReferenceById(respuestaActualizadaDTO.id());
        respuesta.respuestaActualizada(respuestaActualizadaDTO);
        return ResponseEntity.ok(new RespuestaCreadaDto(respuesta.getId(),respuesta.getSolution(),
                respuesta.getAuthor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getCreationDate()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id){
        Respuesta respuesta = repository.getReferenceById(id);
        respuesta.diactivateResponse();
        return ResponseEntity.noContent().build();
    }
}
