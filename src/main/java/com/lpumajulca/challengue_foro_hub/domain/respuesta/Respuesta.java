package com.lpumajulca.challengue_foro_hub.domain.respuesta;

import com.lpumajulca.challengue_foro_hub.domain.topico.Topico;
import com.lpumajulca.challengue_foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDate;
    private String solution;
    @OneToOne
    @JoinColumn(name="author", referencedColumnName="id")
    private Usuario author;
    @OneToOne
    @JoinColumn(name="topico", referencedColumnName="id")
    private Topico topico;
    private boolean active;

    public Respuesta(Long id, String solution, Usuario usuario, Topico topico, LocalDateTime creationDate) {
        this.id=id;
        this.solution=solution;
        this.author=usuario;
        this.topico=topico;
        this.creationDate=LocalDateTime.now();
    }

    public void respuestaActualizada(RespuestaActualizadaDto respuestaActualizadaDto) {
        if (respuestaActualizadaDto.solution() != null){
            this.solution=respuestaActualizadaDto.solution();
        }
    }
    public void diactivateResponse(){

        this.active=false;
    }
}
