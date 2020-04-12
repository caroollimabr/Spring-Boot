package br.com.carol.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //mostra onde a classe está para que ela seja mapeada
public class HelloController {

	@RequestMapping("/") //pede o mapeamento pra URL (mapeia um endpoint)
	@ResponseBody //pede o retorno no corpo do site
	
	public String hello() {
		return "Hello, world!";
	}
}
