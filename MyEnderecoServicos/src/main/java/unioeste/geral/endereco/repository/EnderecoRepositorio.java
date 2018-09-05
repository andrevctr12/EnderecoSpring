package unioeste.geral.endereco.repository;

import unioeste.geral.endereco.bo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByCep(String cep);
}
