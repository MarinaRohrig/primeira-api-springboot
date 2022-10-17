package br.com.futurodev.primeiraapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


//Diz que essa classe é uma entidade
@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto",allocationSize = 1, initialValue = 1)

//implements serialize para implementar a classe que trata do BD
public class ProdutoModel implements Serializable {

    //identifica o ID como PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private double precoUnitario;

    //utiliza-se hash e equals para comparar objeto de uma instância com objetos de outra instâcia
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoModel that = (ProdutoModel) o;
        return Double.compare(that.precoUnitario, precoUnitario) == 0 && id.equals(that.id) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, precoUnitario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
