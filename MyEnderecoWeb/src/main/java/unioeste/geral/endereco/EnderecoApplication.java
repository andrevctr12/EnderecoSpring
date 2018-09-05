package unioeste.geral.endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("unioeste.geral.endereco.bo")
@EnableJpaRepositories("unioeste.geral.endereco")
@ComponentScan("unioeste.geral.endereco.repository")
@ComponentScan("unioeste.geral.endereco.controller")
public class EnderecoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnderecoApplication.class, args);
    }
}
