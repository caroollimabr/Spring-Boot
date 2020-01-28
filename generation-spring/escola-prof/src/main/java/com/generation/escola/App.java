package com.generation.escola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication //Anotação de onde começa nosso aplicativo
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args); //Comando para iniciar o Tomcat com spring
    }
}
