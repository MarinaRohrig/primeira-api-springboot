package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.models.ProdutoModel;
import br.com.futurodev.primeiraapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired // Injeção de dependencias
    private ProdutoRepository produtoRepository;

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


    @RequestMapping(value = "/produto/{descricao}",method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String descricao){
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        produtoRepository.save(produto); // grava no BD um produto apenas com descricao

        return "Produto: "+descricao+", registrado com sucesso!";
    }
}
