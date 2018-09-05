package unioeste.geral.endereco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.geral.endereco.bo.Cidade;
import org.springframework.stereotype.Repository;
import unioeste.geral.endereco.bo.UnidadeFederativa;


public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {
    List<Cidade> findAllByUf(UnidadeFederativa uf);
}
