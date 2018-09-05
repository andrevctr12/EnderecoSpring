package unioeste.geral.endereco.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.geral.endereco.bo.*;
import unioeste.geral.infra.exception.ServiceException;
import java.util.List;

@Service
public class UCEnderecoGeralServicos {
    private CidadeServicos cidade;
    private EnderecoServicos endereco;
    private UfServicos uf;
//    private EnderecoEspecificoServicos enderecoEspecifico;

    @Autowired
    public UCEnderecoGeralServicos(CidadeServicos cidadeServicos,
                                   EnderecoServicos enderecoServicos,
                                   UfServicos ufServicos) {
        this.cidade = cidadeServicos;
        this.endereco = enderecoServicos;
        this.uf = ufServicos;
//        this.enderecoEspecifico = enderecoEspecificoServicos;
    }

    public Endereco cadastrarEndereco(Endereco endereco) throws ServiceException {
        return this.endereco.save(endereco);
    }

    public Endereco obterEnderecoPorCEP(String CEP) throws ServiceException {
        return this.endereco.findByCEP(CEP);
    }

    public List<Endereco> obterEnderecos() throws ServiceException {
      return this.endereco.findAll();
    }

    public Endereco obterEnderecoPorID(Long id) throws ServiceException {
        return this.endereco.find(id);
    }

    //TODO: essa bosta
    public EnderecoEspecifico obterEnderecoExterno(String site) {
        return new EnderecoEspecifico();
    }

    public Cidade obterCidade(Cidade cidade) throws ServiceException {
        if(cidade.getId() != null)
            return this.cidade.find(cidade.getId());
        else {
            throw new ServiceException("Não foi possível encontrar a cidade");
        }

    }

    public List<Cidade> obterCidadesPorIdUf(String siglaUf) {
        UnidadeFederativa uf = this.uf.findBySigla(siglaUf);
        return this.cidade.findAllByUf(uf);
    }

    public List<UnidadeFederativa> obterUf() {
        return this.uf.findAll();
    }
}
