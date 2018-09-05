package unioeste.geral.endereco.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Bairro implements Serializable {

    public Bairro(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Bairro() {

    }

    @Id
    private Long id;

    private String nome;

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
}
