package controller.form;

import com.sun.istack.NotNull;
import controller.repository.CursoRepository;

import domain.Curso;
import domain.Topico;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class TopicoForm {


    @NotNull  @NotEmpty @Length (min = 10)  //faz  com que ele nao possa ser nulo em seus valores // NAO vazio
    private String titulo;
    @NotNull  @NotEmpty @Length (min = 10)
    private String mensagem;
    @NotNull  @NotEmpty @Length (min = 10)
    private  String nomeCurso;


    public Topico converter(CursoRepository cursoRepository) {

        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
