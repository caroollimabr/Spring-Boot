package br.com.carol.forum.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.carol.forum.model.Usuario;
import br.com.carol.forum.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository repository;
	
	//injeção de atributos via construtor, já que no filter não se põe @Autowired porque não é um bean gerenciado pelo Spring
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		if (valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private void autenticarCliente(String token) {
		
		Long idUsuario = tokenService.getIdUsuario(token);
		
		Usuario usuario = repository.findById(idUsuario).get(); //get() carrega o obj na memória
				
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization"); //o local onde tem que adicionar o token
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
		
			return null;
		}
		
		return token.substring(7, token.length());
	}
	
	

}
