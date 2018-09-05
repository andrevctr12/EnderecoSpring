package unioeste.geral.endereco.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UnidadeFederativa implements Serializable {
    public UnidadeFederativa(Long id, String sigla, String nome, Pais pais) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.pais = pais;
    }

    public UnidadeFederativa() { 
      this.pais = new Pais();
    }

    @Id
    private Long id;

    private String sigla;

    private String nome;

    @ManyToOne
    private Pais pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
