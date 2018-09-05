package unioeste.geral.endereco.manager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unioeste.geral.endereco.bo.Bairro;
import unioeste.geral.endereco.bo.Cidade;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.bo.Logradouro;
import unioeste.geral.endereco.bo.Pais;
import unioeste.geral.endereco.bo.UnidadeFederativa;
import unioeste.geral.endereco.repository.EnderecoRepositorio;
import unioeste.geral.infra.exception.ServiceException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

@Service
public class EnderecoServicos {
    private EnderecoRepositorio repositorio;

    @Autowired
    public EnderecoServicos(EnderecoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Endereco save(Endereco endereco) throws ServiceException {
        try {
            return repositorio.save(endereco);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível salvar o endereço");
        }
    }

    public void delete(Long id) throws ServiceException {
        try {
            this.repositorio.deleteById(id);
        } catch (RuntimeException e) {
            throw new ServiceException("Não foi possível remover o endereço");
        }
    }

    public Endereco find(Long id) throws ServiceException {
        return this.repositorio.findById(id).orElseThrow(() -> new ServiceException("Não foi possível encontrar o Endereço"));
    }

    private static JsonObject getCepResponse(String cep) {

        JsonObject responseJO = null;

        try {
            if (!Endereco.validaCep(cep)) {
                throw new ServiceException("Formato de CEP inválido");
            }

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/" + cep + "/json");
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            responseJO = Json.createReader(entity.getContent()).readObject();

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

        return responseJO;
    }

    public Endereco findByCEP(String cep) throws ServiceException {
        JsonObject jsonObject = getCepResponse(cep);
        Endereco endereco = null;

        JsonValue erro = jsonObject.get("erro");

        if (erro == null) {

          Logradouro logradouro = new Logradouro();
          logradouro.setNome(jsonObject.getString("logradouro"));
          Pais pais = new Pais();
          pais.setNome("Brasil");
          UnidadeFederativa uf = new UnidadeFederativa();
          uf.setNome(jsonObject.getString("uf"));
          uf.setPais(pais);
          Cidade cidade = new Cidade();
          cidade.setNome(jsonObject.getString("localidade"));
          cidade.setUf(uf);
          Bairro bairro = new Bairro();
          bairro.setNome(jsonObject.getString("bairro"));
          
          endereco = new Endereco(
            null,
            jsonObject.getString("cep"),
            logradouro,
            bairro,
            cidade
          );
        }
        else {
            throw new ServiceException("CEP não existe");
        }

        return endereco;
    }

    public List<Endereco> findAll() {
        return repositorio.findAll();
    }
}
