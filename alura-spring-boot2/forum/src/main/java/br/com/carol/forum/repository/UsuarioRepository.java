package br.com.carol.forum.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carol.forum.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email); //pode ser que encontre um usuário com esse email ou não

}
