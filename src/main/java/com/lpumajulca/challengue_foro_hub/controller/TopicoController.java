package com.lpumajulca.challengue_foro_hub.controller;


import com.lpumajulca.challengue_foro_hub.domain.topico.*;
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
@RequestMapping("/topico")
@SecurityRequirement(name="bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;


    @PostMapping("/topico")
    @Transactional
    public ResponseEntity topicoRegistrado(@RequestBody @Valid TopicoDto topicoDto) throws ValidacionDeIntegridad {
        var topicoRegistrado = topicoService.topicoCreado(topicoDto);
        return ResponseEntity.ok(topicoRegistrado);
    }

    @GetMapping("/topicos")
    public ResponseEntity<Page<ListarTopicoDto>>  listarTopicos(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(topicoRepository.findByActiveTrue(paged).map(ListarTopicoDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity <RespuestaTopicoDto> respuestaTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var topicoId = new RespuestaTopicoDto(topico.getId(),
                topico.getTitle(),
                topico.getMessage(),
                topico.getStatus(),
                topico.getAuthor().getId(),
                topico.getCourse(),
                topico.getDate());
        return ResponseEntity.ok(topicoId);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity topicoActualizado (@RequestBody @Valid TopicoActualizadoDto topicoActualizadoDto){
        Topico topico= topicoRepository.getReferenceById(topicoActualizadoDto.id());
        topico.topicoActualizado(topicoActualizadoDto);
        return ResponseEntity.ok(new RespuestaTopicoDto(topico.getId(),
                topico.getTitle(),topico.getMessage(),
                topico.getStatus(),topico.getAuthor().getId(),
                topico.getCourse(),topico.getDate()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        topico.diactivateTopic();
        return ResponseEntity.noContent().build();
    }
}
