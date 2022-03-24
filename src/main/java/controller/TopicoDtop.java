package controller;

import domain.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
