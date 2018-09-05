package unioeste.geral.endereco.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.bo.EnderecoEspecifico;
import unioeste.geral.endereco.repository.EnderecoEspecificoRepositorio;
import unioeste.geral.endereco.repository.EnderecoRepositorio;
import unioeste.geral.infra.exception.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoEspecificoServicos {
   private EnderecoEspecificoRepositorio repositorio;

   @Autowired
   public EnderecoEspecificoServicos(EnderecoEspecificoRepositorio repositorio) {
       this.repositorio = repositorio;
   }

   public EnderecoEspecifico save(EnderecoEspecifico endereco) throws ServiceException {
       try {
           return repositorio.save(endereco);
       }
       catch (RuntimeException e) {
           throw new ServiceException("Não foi possível salvar o endereço especifico");
       }
   }

   public void delete(Long id) throws ServiceException {
       try {
           this.repositorio.deleteById(id);
       }
       catch (RuntimeException e) {
           throw new ServiceException("Não foi possível remover o endereço especifico");
       }
   }

   public EnderecoEspecifico find(Long id) {
       return repositorio.findById(id).orElseThrow(() -> new ServiceException("Não foi possível encontrar o Endereço"));
   }

   public List<EnderecoEspecifico> findAll() {
       return repositorio.findAll();
   }

}
