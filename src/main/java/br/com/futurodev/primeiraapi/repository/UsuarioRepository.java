package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {

}
