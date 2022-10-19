package br.com.futurodev.primeiraapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String senha;

    private String nome;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp(0) without time zone DEFAULT timezone('utc'::text,CURRENT_TIMESTAMP(0))",updatable = false)
    private OffsetDateTime dataCadasto;

    @UpdateTimestamp
    @Column(columnDefinition = "timestamp(0) without time zone DEFAULT timezone('utc'::text,CURRENT_TIMESTAMP(0))")
    private OffsetDateTime dataAtualizacao;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    // FetchType para forçar o padrão Eager, já que por ser uma lista ele estava vindo
    @JsonManagedReference
    private List<TelefoneModel> telefones = new ArrayList<TelefoneModel>();

    public OffsetDateTime getDataCadasto() {
        return dataCadasto;
    }

    public void setDataCadasto(OffsetDateTime dataCadasto) {
        this.dataCadasto = dataCadasto;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }




    public List<TelefoneModel> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneModel> telefones) {
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
