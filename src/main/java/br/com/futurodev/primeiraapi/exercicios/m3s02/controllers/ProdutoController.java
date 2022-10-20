package br.com.futurodev.primeiraapi.exercicios.m3s02.controllers;

import br.com.futurodev.primeiraapi.exercicios.m3s02.repository.ProdutoRepository;
import br.com.futurodev.primeiraapi.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.futurodev.primeiraapi.exercicios.m3s02.*;

import java.util.List;

public class ProdutoController {
    @Autowired // Injeção de dependencias
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/produtos")
    @ResponseBody // retorna os dados no corpo da respost, responed entity gera um json
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){

        List<ProdutoModel> produtos =  produtoRepository.findAll(); // consulta o bd para pegar os produtos

        return new ResponseEntity<List<ProdutoModel>>(produtos, HttpStatus.OK); // retorna o JSON da lista

    }

    @PostMapping(value = "/produto/salvar")
    @ResponseBody
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produto){

        ProdutoModel prod = produtoRepository.save(produto); // envia pelo repository o produto para salvar
        return new ResponseEntity<ProdutoModel>(prod, HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/produto/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto){  // solicita um parametro que é o id para poder localizar o produto que precisa excluir

        produtoRepository.deleteById(idProduto);

        return new ResponseEntity<String>("Produto deletado com sucesso.",HttpStatus.OK);

    }
}
