package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.models.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
//Tudo que cair no localhost:8000/usuario cai nessa classe para controle

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping(value = "/", produces= "application/json") // quando fizer uma requisição localhost:8000/usuario e usar o POST, cai aqui
    public ResponseEntity<UsuarioModel> cadastrar(@RequestBody UsuarioModel usuario){ // recebe o json da requisição e converte para um objeto UsuarioModel
        UsuarioModel usu = usuarioRepository.save(usuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
    }


}
