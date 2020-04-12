package br.com.carol.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.carol.forum.repository.UsuarioRepository;

@EnableWebSecurity //Habilita configurações de segurança
@Configuration //mostra que é classe de configuração

public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired //injeção de dependência
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//sobrescrevendo AuthenticationManager
	@Override
	@Bean //esse método devolve o AuthenticationManager para ser injetado no Controller
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//método para configurar a autenticação (login etc)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder()); //passwordEncoder: codifica a senha para não ficar visível na DB
	}
	
	//método para configurações de autorização (URL)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll() //aqui vc libera o acesso no método GET
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll() //tudo o que for topicos+algo, permitir no método GET
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
		.anyRequest().authenticated() //qualquer outra deverá ser autenticada (ou seja, não será pública)
		.and().csrf().disable()//desabilitar suporte a tipo de ataque hacker que aplicação web está sujeita, já que vms fz autenticação via token
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //não crie sessão pq a autenticação vai ser stateless (n vai ser sessão)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	}
	
	//método para configurações de recursos estáticos (CSS, JS, imagens, etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	public static void main (String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
	
	

}
