package unioeste.geral.endereco.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.bo.UnidadeFederativa;
import unioeste.geral.endereco.repository.CidadeRepositorio;
import unioeste.geral.infra.exception.ServiceException;

@Service
public class CidadeServicos {
    private CidadeRepositorio repositorio;

    @Autowired
    public CidadeServicos(CidadeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Cidade save(Cidade cidade) {
        try {
            return repositorio.save(cidade);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível salvar a cidade");
        }
    }

    public void delete(Long id) throws ServiceException {
        try {
            this.repositorio.deleteById(id);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível remover a cidade");
        }
    }

    public Cidade find(Long id) throws ServiceException {
        return this.repositorio.findById(id).orElseThrow(() -> new ServiceException("Não foi possível encontrar a cidade"));
    }

    public List<Cidade> findAll() {
        return repositorio.findAll();
    }

    public List<Cidade> findAllByUf(UnidadeFederativa uf) throws ServiceException {
        return this.repositorio.findAllByUf(uf);
    }

}
