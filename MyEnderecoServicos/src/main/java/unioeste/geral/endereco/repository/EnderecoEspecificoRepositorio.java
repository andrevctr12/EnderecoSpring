package unioeste.geral.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.geral.endereco.bo.EnderecoEspecifico;

public interface EnderecoEspecificoRepositorio extends JpaRepository<EnderecoEspecifico, Long> { }
