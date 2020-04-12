package br.com.carol.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.carol.forum.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		//método para gerar o token
		return Jwts.builder()
				.setIssuer("API do fórum da Carol")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)//data de criação
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret) 
				.compact();
	}

	//método validação token
	public boolean isTokenValido(String token) {
		
		try {
		Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token); //parser: descriptografa o token; parseCLaims: verifica se está tudo ok e devolve o obj ou exception
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	//método recuperar dados do usuário
	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody(); 
		return Long.parseLong(claims.getSubject()); //pega o id do usuário
	}

}
