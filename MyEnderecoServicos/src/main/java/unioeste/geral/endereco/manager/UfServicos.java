package unioeste.geral.endereco.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.geral.endereco.bo.UnidadeFederativa;
import unioeste.geral.endereco.repository.UfRepositorio;
import unioeste.geral.infra.exception.ServiceException;

import java.util.List;

@Service
public class UfServicos {
    private UfRepositorio repositorio;

    @Autowired
    public UfServicos(UfRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public UnidadeFederativa save(UnidadeFederativa uf) {
        try {
            return repositorio.save(uf);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível salvar o estado");
        }
    }

    public void delete(Long id) throws ServiceException {
        try {
            this.repositorio.deleteById(id);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível remover o estado");
        }
    }

    public UnidadeFederativa find(Long id) throws ServiceException {
        return this.repositorio.findById(id).orElseThrow(() -> new ServiceException("Não foi possível encontrar o estado"));
    }

    public List<UnidadeFederativa> findAll() {
        return repositorio.findAll();
    }

    public UnidadeFederativa findBySigla(String sigla) throws ServiceException {
        return this.repositorio.findBySigla(sigla).orElseThrow(() -> new ServiceException("Não foi possível encontrar o estado"));
    }

}
