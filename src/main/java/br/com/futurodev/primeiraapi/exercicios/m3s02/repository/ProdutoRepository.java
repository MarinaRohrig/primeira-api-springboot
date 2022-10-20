package br.com.futurodev.primeiraapi.exercicios.m3s02.repository;

import br.com.futurodev.primeiraapi.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {


}

