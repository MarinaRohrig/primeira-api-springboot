package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.models.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
//Tudo que cair no localhost:8000/usuario cai nessa classe para controle

public class UsuarioController {


    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

 /*
      @Autowired
    private UsuarioRepository usuarioRepository;

  @PostMapping(value = "/", produces= "application/json") // quando fizer uma requisição localhost:8000/usuario e usar o POST, cai aqui
    public ResponseEntity<UsuarioModel> cadastrar(@RequestBody UsuarioModel usuario){ // recebe o json da requisição e converte para um objeto UsuarioModel
//        UsuarioModel usu = usuarioRepository.save(usuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.CREATED);
    }
     @PutMapping(value="/",produces= "application/json")
    public ResponseEntity<UsuarioModel> atualizar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = usuarioRepository.save(usuario);
        return new ResponseEntity<UsuarioModel>(usu,HttpStatus.OK);
    }

      @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

@GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioModel> getUserByid(@PathVariable(value = "idUsuario")Long idUsuario){
        UsuarioModel usu = usuarioRepository.findById(idUsuario).get();

        return new ResponseEntity<UsuarioModel>(usu,HttpStatus.OK);
    }

    @GetMapping (value = "/buscarPorNome",produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsuarioModel>> getUserByName(@RequestParam (name = "nome") String nome){
        List <UsuarioModel> usuarios = usuarioRepository.getUserByname(nome);
        return new ResponseEntity<List<UsuarioModel>>(usuarios,HttpStatus.OK);
    }

    */

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioModel> cadastrar(@RequestBody UsuarioModel usuario) {
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.CREATED);
    }

    @PutMapping(value="/",produces= "application/json")
    public ResponseEntity<UsuarioModel> atualizar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioModel>(usu,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUsuario){
       cadastroUsuarioService.delete(idUsuario);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioModel> getUserByid(@PathVariable(value = "idUsuario")Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById(idUsuario);
        return new ResponseEntity<UsuarioModel>(usu,HttpStatus.OK);
    }

    @GetMapping (value = "/buscarPorNome",produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsuarioModel>> getUserByName(@RequestParam (name = "nome") String nome){
        List<UsuarioModel> usuarios = cadastroUsuarioService.getUserByName(nome);
        return new ResponseEntity<List<UsuarioModel>>(usuarios,HttpStatus.OK);
    }


}
