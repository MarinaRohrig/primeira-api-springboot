package br.com.futurodev.primeiraapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostranome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }


    @GetMapping(value = "/hello/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@PathVariable String nome){
        return "Olá "+nome;
    }

//teste de response
    @GetMapping(value ="/mostranomebr/{nome}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String mostraNome(@PathVariable String nome){
        return "Olá " +nome;
    }
}
