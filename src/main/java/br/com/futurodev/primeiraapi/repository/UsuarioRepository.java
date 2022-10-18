package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.models.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    @Query(value = "select u from UsuarioModel u where u.nome like %?1%")
    List<UsuarioModel> getUserByName(String nome);
}
