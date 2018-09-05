package unioeste.geral.endereco.teste;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import unioeste.geral.endereco.bo.Bairro;
import unioeste.geral.endereco.bo.Endereco;
import unioeste.geral.endereco.bo.EnderecoEspecifico;
import unioeste.geral.endereco.controller.EnderecoControlador;
import unioeste.geral.endereco.manager.UCEnderecoGeralServicos;

@RunWith(SpringRunner.class)
@WebMvcTest(EnderecoControlador.class)
public class EnderecoTeste {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UCEnderecoGeralServicos servico;

    @Test
    public void cadastrarEndereco() {
    }



}
