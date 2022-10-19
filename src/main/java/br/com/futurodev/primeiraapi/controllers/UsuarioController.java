package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.dto.TelefoneRepresentationModel;
import br.com.futurodev.primeiraapi.dto.UsuarioRepresentationModel;
import br.com.futurodev.primeiraapi.input.UsuarioInput;
import br.com.futurodev.primeiraapi.models.TelefoneModel;
import br.com.futurodev.primeiraapi.models.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Usuários")
@RestController
@RequestMapping(value = "/usuarios")
//Tudo que cair no localhost:8000/usuario cai nessa classe para controle

public class UsuarioController {


    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @ApiOperation("Salva o usuário")
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> cadastrar(@RequestBody UsuarioInput usuarioInput) {
        UsuarioModel usu = toDomainObject(usuarioInput);
        cadastroUsuarioService.salvar(usu);
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.CREATED);
    }

    @ApiOperation("Atualiza o usuário")
    @PutMapping(value="/",produces= "application/json")
    public ResponseEntity<UsuarioRepresentationModel> atualizar(@RequestBody UsuarioInput usuarioInput){
        UsuarioModel usu = cadastroUsuarioService.salvar(toDomainObject(usuarioInput));
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu),HttpStatus.OK);
    }

    @ApiOperation("Deleta o usuário")
    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete( @ApiParam(value= "ID do usuário") @RequestParam Long idUsuario){
       cadastroUsuarioService.delete(idUsuario);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }

    @ApiOperation("Busca o usuário pelo ID")
     @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> getUserByid(@PathVariable(value = "idUsuario")Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById((idUsuario));

         UsuarioRepresentationModel usuarioRepresentationModel = toModel(usu);

         return new ResponseEntity<UsuarioRepresentationModel>(usuarioRepresentationModel,HttpStatus.OK);

    }

    @ApiOperation("Busca o usuário pelo nome")
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
        usuarioRepresentationModel.setSenha(usu.getSenha());
        usuarioRepresentationModel.setDataCadastro(usu.getDataCadasto());
        usuarioRepresentationModel.setDataAtualizacao(usu.getDataAtualizacao());


        for (int i=0; i<usu.getTelefones().size();i++){
            TelefoneRepresentationModel telefonesRepresentationModel = new TelefoneRepresentationModel();
            telefonesRepresentationModel.setId(usu.getTelefones().get(i).getId());
            telefonesRepresentationModel.setNumero(usu.getTelefones().get(i).getNumero());
            telefonesRepresentationModel.setTipo(usu.getTelefones().get(i).getTipo());

            usuarioRepresentationModel.getTelefones().add(telefonesRepresentationModel);
        }

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

        for (int i=0; i<usuarioInput.getTelefones().size(); i++){
            TelefoneModel telefoneModel = new TelefoneModel();
            telefoneModel.setTipo(usuarioInput.getTelefones().get(i).getTipo());
            telefoneModel.setNumero(usuarioInput.getTelefones().get(i).getNumero());
            telefoneModel.setId(usuarioInput.getTelefones().get(i).getId());
            telefoneModel.setUsuario(usuarioModel);

            usuarioModel.getTelefones().add(telefoneModel);


        }

        return usuarioModel;

    }

}
