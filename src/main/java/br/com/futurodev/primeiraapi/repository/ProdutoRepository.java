package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


//informa o tipo de dado que essa classe vai manipular, no caso ProdutoModel e o tipo da PK que é Long
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {


}
