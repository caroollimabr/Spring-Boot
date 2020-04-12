package br.com.carol.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport //habilita o Spring pegar os parâmetros da URL e repassar para o Spring Data
@EnableCaching //permitir caching (armazenamento de dados para ganho de performance)
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args); /*Classe usada para rodar a aplicação*/
	}

}
