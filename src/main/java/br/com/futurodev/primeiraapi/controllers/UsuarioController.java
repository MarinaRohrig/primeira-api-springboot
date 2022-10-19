package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.dto.UsuarioRepresentationModel;
import br.com.futurodev.primeiraapi.input.UsuarioInput;
import br.com.futurodev.primeiraapi.models.TelefoneModel;
import br.com.futurodev.primeiraapi.models.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
//Tudo que cair no localhost:8000/usuario cai nessa classe para controle

public class UsuarioController {


    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> cadastrar(@RequestBody UsuarioInput usuarioInput) {
        UsuarioModel usu = toDomainObject(usuarioInput);
        cadastroUsuarioService.salvar(usu);
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.CREATED);
    }

    @PutMapping(value="/",produces= "application/json")
    public ResponseEntity<UsuarioRepresentationModel> atualizar(@RequestBody UsuarioInput usuarioInput){
        UsuarioModel usu = cadastroUsuarioService.salvar(toDomainObject(usuarioInput));
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu),HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUsuario){
       cadastroUsuarioService.delete(idUsuario);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

     @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> getUserByid(@PathVariable(value = "idUsuario")Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById((idUsuario));

         UsuarioRepresentationModel usuarioRepresentationModel = toModel(usu);

         return new ResponseEntity<UsuarioRepresentationModel>(usuarioRepresentationModel,HttpStatus.OK);

    }

    @GetMapping (value = "/buscarPorNome",produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsuarioRepresentationModel>> getUserByName(@RequestParam (name = "nome") String nome){
         //pega as entidades
        List<UsuarioModel> usuarios = cadastroUsuarioService.getUserByName(nome);
        // converte usuariomodel em representation model (DTO)
        List<UsuarioRepresentationModel> usuariosRepresentationModel = toCollectionModel(usuarios);
        return new ResponseEntity<List<UsuarioRepresentationModel>>(usuariosRepresentationModel,HttpStatus.OK);
    }
    private UsuarioRepresentationModel toModel(UsuarioModel usu) {
        UsuarioRepresentationModel usuarioRepresentationModel = new UsuarioRepresentationModel();
        usuarioRepresentationModel.setId(usu.getId());
        usuarioRepresentationModel.setNome(usu.getNome());
        usuarioRepresentationModel.setLogin(usu.getLogin());

        usuarioRepresentationModel.setTelefones(usu.getTelefones());

        return usuarioRepresentationModel;
    }

    private List<UsuarioRepresentationModel> toCollectionModel(List<UsuarioModel> usuariosModel){
         return usuariosModel.stream().map(usuarioModel -> toModel(usuarioModel) )
                 .collect(Collectors.toList());

    }

    //converte um objeto do tipo usuarioinput para usuariomodel
    private UsuarioModel toDomainObject(UsuarioInput usuarioInput){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioInput.getId());
        usuarioModel.setNome(usuarioInput.getNome());
        usuarioModel.setLogin(usuarioInput.getLogin());
        usuarioModel.setSenha(usuarioInput.getSenha());

      /*  for (int i=0; i<usuarioInput.getTelefones().size(); i++){
            TelefoneModel telefoneModel = new TelefoneModel();
            telefoneModel.setTipo(usuarioInput.getTelefones().get(i).getTipo());
            telefoneModel.setNumero(usuarioInput.getTelefones().get(i).getNumero);
            telefoneModel.setId(usuarioInput.getTelefones().get(i).getId);
            telefoneModel.setUsuario(usuarioModel);

            usuarioModel.getTelefones().add(telefoneModel);


        } */

        return usuarioModel;

    }

}
