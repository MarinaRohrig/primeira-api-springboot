package br.com.futurodev.primeiraapi.dto;

import br.com.futurodev.primeiraapi.models.TelefoneModel;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepresentationModel {
    private Long id;
    private String nome;
    private String login;

    private OffsetDateTime dataCadastro;

    private OffsetDateTime dataAtualizacao;

    private List<TelefoneModel> telefones = new ArrayList<TelefoneModel>();

    public List<TelefoneModel> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneModel> telefones) {
        this.telefones = telefones;
    }

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
