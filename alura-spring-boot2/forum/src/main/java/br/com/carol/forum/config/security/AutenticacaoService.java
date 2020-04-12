package br.com.carol.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.carol.forum.model.Usuario;
import br.com.carol.forum.repository.UsuarioRepository;

@Service //esta é uma classe de Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	//Unimplemented method de UserDetailsService, agora implementado
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //consulta no banco já filtrando pelo usuário e assim, ele acha a senha
		Optional<Usuario> usuario = repository.findByEmail(username); //Optional: pode ser que encontre um usuário com esse email ou não
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
		
	}
	

}
