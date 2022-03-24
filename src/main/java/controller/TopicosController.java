package controller;

import domain.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import controller.repository.TopicoRepository;

import java.util.List;

@Component
@RequestMapping("/topicos") // faz com que a classe inteira responda por essa url
@EnableAutoConfiguration //arruma o erro do repositorio
@RestController // rest
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    //    @RequestMapping(value = "/topicos" , method = RequestMethod.GET) //usando metodos http
    //   @ResponseBody
    @GetMapping  //usa o verbo Http Get
    public List<TopicoDtop> lista(String nomeCurso) {

        if (nomeCurso == null) {

            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDtop.converter(topicos);
        } else {

            List<Topico> topicos = topicoRepository.findAllByCurso_Nome(nomeCurso); //
            return TopicoDtop.converter(topicos);
        }

    }

    @PostMapping //usa o metodo http post
    public void cadastrar(TopicoForm topico) {



    }


}
