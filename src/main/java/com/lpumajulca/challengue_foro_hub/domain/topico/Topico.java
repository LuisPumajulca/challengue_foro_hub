package com.lpumajulca.challengue_foro_hub.domain.topico;

import com.lpumajulca.challengue_foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Estado status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "author_id")
    private Usuario author;
    private String course;
    private boolean active;

    public Topico(Long id, String title, String message, LocalDateTime date, Estado status, Usuario usuario, String curso) {
        this.id=id;
        this.title=title;
        this.message=message;
        this.date = date;
        this.date=LocalDateTime.now();
        this.status=status;
        this.author=usuario;
        this.course=curso;
    }

    public void topicoActualizado(TopicoActualizadoDto topicoActualizadoDto) {
        if (topicoActualizadoDto.title() !=null){
            this.title= topicoActualizadoDto.title();
        }
        if (topicoActualizadoDto.message() != null){
            this.message=topicoActualizadoDto.message();
        }
        if (topicoActualizadoDto.status() != null){
            this.status=topicoActualizadoDto.status();
        }
        if (topicoActualizadoDto.curso() != null){
            this.course=topicoActualizadoDto.curso();
        }
    }
    public void diactivateTopic(){
        this.active=false;
    }
}
