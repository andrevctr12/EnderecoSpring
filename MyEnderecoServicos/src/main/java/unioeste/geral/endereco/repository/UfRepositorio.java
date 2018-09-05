package unioeste.geral.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.geral.endereco.bo.UnidadeFederativa;

import java.util.Optional;

public interface UfRepositorio extends JpaRepository<UnidadeFederativa, Long> {
    Optional<UnidadeFederativa> findBySigla(String sigla);
}
