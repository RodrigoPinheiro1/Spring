package controller.repository;

import domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository <Topico, Long> {


    List<Topico> findAllByCurso_Nome(String nomeCurso); //Curso é o relacionamento e nome é o atributo  o "_" serve para separar para não dar conflitos de nome,





}
