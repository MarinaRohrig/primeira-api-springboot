package br.com.futurodev.primeiraapi.service;

import br.com.futurodev.primeiraapi.models.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvar (UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

}
