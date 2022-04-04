package controller.Dto;

import domain.Topico;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicoDtop {

    private Long id ;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDtop(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }
    public static List<TopicoDtop> converter(List<Topico> topicos) {

    return topicos.stream().map(TopicoDtop :: new ).collect(Collectors.toList());//convert
    }


}
