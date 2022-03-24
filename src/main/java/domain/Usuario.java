package domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Usuario {

     @Id @GeneratedValue (strategy = GenerationType.IDENTITY) //identity é auto incremento
    private Long id;
    private String nome;
    private String email;
    private String senha;



    @Controller
    public static class TopicosController {

        @RequestMapping("/topicos")
        @ResponseBody
        public List<Topico> lista(){

            Topico topico = new Topico("Duvida","Duvida com Spring", new Curso("Spring", "Programacao"));
            return Arrays.asList(topico);
        }
    }
}
