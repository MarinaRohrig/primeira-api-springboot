package br.com.futurodev.primeiraapi.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "telefone")
public class TelefoneModel {
    @Id
    @SequenceGenerator(name = "seq_telefone",sequenceName = "seq_telefone")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_telefone")
    private Long id;
    private String numero;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefoneModel that = (TelefoneModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
