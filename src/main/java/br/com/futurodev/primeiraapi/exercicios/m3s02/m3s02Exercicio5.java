package br.com.futurodev.primeiraapi.exercicios.m3s02;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/exercicio5")
public class m3s02Exercicio5 {
    @GetMapping(value = "/olah/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String olah(@PathVariable String nome){
        return "Olá "+nome+", estamos começando nosso trabalho com Spring Boot!";
    }

    @GetMapping(value = "/media/{nota1}/{nota2}",produces = "application/json")
    public String media(@PathVariable Double nota1, Double nota2){
        return "A média é: "+((nota1+nota2)/2)+".";
    }


}
