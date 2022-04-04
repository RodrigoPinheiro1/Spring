package controller;

import controller.Dto.DetalhesDoTopicoDtop;
import controller.Dto.TopicoDtop;
import controller.form.AtualizacaoTopicoForm;
import controller.form.TopicoForm;
import controller.repository.CursoRepository;
import domain.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import controller.repository.TopicoRepository;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@RequestMapping("/topicos") // faz com que a classe inteira responda por essa url
@EnableAutoConfiguration //arruma o erro do repositorio
@RestController // rest
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

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
    @PostMapping //usa o metodo http post  valido usada para validar caso está certo, senao vai ar erro
    @Transactional
    public ResponseEntity<TopicoDtop> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriComponentsBuilder) { //faz com que ele pegue do corpo e nao da url.

        Topico topico =form.converter(cursoRepository);
        topicoRepository.save(topico);

        // uriComponets é metodo estatico que traz as informações automaticas do servidor
        // o {id } serve para separar pelo id , to uri converte o atributo em uma uri.
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri() ;
        return ResponseEntity.created(uri).body(new TopicoDtop(topico)) ;//metodo created cria o metodo 201 faz com que ele cria uma nova uri

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoTopicoDtop> detalhar (@PathVariable Long id) { //o parametro do id vai vir pela url a class@path cria uma variavel na url


      Optional<Topico> topico =  topicoRepository.findById(id);
      if(topico.isPresent()) { //is presente, está presente, se existe
          return ResponseEntity.ok(new DetalhesDoTopicoDtop(topico.get()));
      }

      return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")   //diferença entre put e pet, put sobrescreve tudo,   o pet sobrescreve uma parte.
    @Transactional //avisa ai spring que precisa fazer essa transação atualizar

    public  ResponseEntity<TopicoDtop> atualizar (@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form ) {

        Optional<Topico> optional =  topicoRepository.findById(id);
        if(optional.isPresent()) { //is presente, está presente, se existe
            Topico topico=  form.atualizar(id, topicoRepository);

            return ResponseEntity.ok(new TopicoDtop(topico));
        }



        return ResponseEntity.notFound().build();
    }




    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity <?> remover (@PathVariable Long id) {

        Optional<Topico> optional =  topicoRepository.findById(id);
        if(optional.isPresent()) {

            topicoRepository.deleteById(id);

            return ResponseEntity.ok().build(); //devolve a requisição

        }

        return ResponseEntity.notFound().build();
    }


}
