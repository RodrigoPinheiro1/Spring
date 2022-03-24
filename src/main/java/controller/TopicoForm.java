package controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.StringNVarcharType;


@Getter
@Setter
public class TopicoForm {


    private String titulo;
    private String mensagem;
    private  String nomeCurso;



}
