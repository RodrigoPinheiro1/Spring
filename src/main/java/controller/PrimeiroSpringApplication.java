package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


//@EnableAutoConfiguration
@EntityScan(basePackages = {"domain"}) // faz a leitura das classes para transformar em tabelas
@SpringBootApplication
public class PrimeiroSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimeiroSpringApplication.class, args);
    }

}
