package com.helloworldcompany.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Define que a classe será acionada a partir da URL
@RestController
public class HelloController {
	
	//acesso será via URL pelo método GET blabla/hello
	//sayHello() - retorna msg de boas vindas
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, world! - Primeiro projeto Spring Boot";
	}

}
