package unioeste.geral.endereco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.bo.EnderecoEspecifico;
import unioeste.geral.endereco.bo.UnidadeFederativa;
import unioeste.geral.endereco.manager.UCEnderecoGeralServicos;
import unioeste.geral.infra.exception.ControllerException;
import unioeste.geral.infra.exception.ServiceException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@CrossOrigin
@RestController
public class EnderecoControlador {
    @Autowired
    private UCEnderecoGeralServicos servicos;


    @PostMapping("/endereco")
    public Endereco cadastrar(@RequestBody Endereco endereco) {
        try {
            return servicos.cadastrarEndereco(endereco);
        }
        catch (ServiceException e) {
            throw new ControllerException(BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/endereco")
    public Endereco alterar(@RequestBody Endereco endereco) {
        try {
            return servicos.cadastrarEndereco(endereco);
        }
        catch (ServiceException e) {
            throw new ControllerException(BAD_REQUEST, e.getMessage());
        }
    }

//    @DeleteMapping("/endereco/{id}")
//    public void delete(@PathVariable Long id) {
//        try {
//
//        }
//        catch (ServiceException e) {
//            throw new ControllerException(CONFLICT, e.getMessage());
//        }
//    }

    @GetMapping("/endereco/{id}")
    public Endereco obterPorId(@PathVariable Long id) {
        Endereco response;
        try {
            response = servicos.obterEnderecoPorID(id);
        }
        catch (Exception e) {
            throw new ControllerException(NOT_FOUND, "Endereço não encontrado");
        }

        return response;
    }

//    @GetMapping("/enderecoEspecifico/{id}")
//    public EnderecoEspecifico obterEnderecoPorId(@PathVariable Long id) {
//        Endereco response;
//        try {
//            response = servicos(id);
//        }
//        catch (Exception e) {
//            throw new ControllerException(NOT_FOUND, "Endereço não encontrado");
//        }
//
//        return response;
//    }

    @GetMapping("/endereco/cep/{cep}")
    public Endereco obterPorCep(@PathVariable String cep) {
        Endereco response;
        try {
            response = servicos.obterEnderecoPorCEP(cep);
        }
        catch (Exception e) {
            throw new ControllerException(NOT_FOUND, "Endereço não encontrado");
        }

        return response;
    }

    @GetMapping("endereco/cidade/{id}")
    public Cidade obterCidade(@PathVariable Long id) {
        Cidade cidade = new Cidade();
        cidade.setId(id);
        try {
            cidade = servicos.obterCidade(cidade);
        }
        catch (Exception e) {
            throw new ControllerException(NOT_FOUND, "Endereço não encontrado");
        }
        return cidade;
    }

    @GetMapping("endereco/cidade/siglaUf/{siglaUf}")
    public List<Cidade> obterCidadesPorSiglaUf(@PathVariable String siglaUf) {
        return servicos.obterCidadesPorSiglaUf(siglaUf);
    }



    @GetMapping("/endereco/externo/{site}")
    public EnderecoEspecifico obterEnderecoExterno(@PathVariable String site) {
        EnderecoEspecifico response;
        try {
            response = servicos.obterEnderecoExterno(site);
        }
        catch (Exception e) {
            throw new ControllerException(NOT_FOUND, "Endereço não encontrado");
        }
        return response;
    }

    @GetMapping("/endereco/uf")
    public List<UnidadeFederativa> obterUnidadeFederativa() {
        return servicos.obterUf();
    }




    @GetMapping(value = "/endereco")
    public List<Endereco> findAll() {
        return servicos.obterEnderecos();
    }


}
