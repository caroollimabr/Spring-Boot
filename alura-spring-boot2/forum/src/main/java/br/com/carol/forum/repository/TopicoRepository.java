package br.com.carol.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carol.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> { //como é interface, não precisa de nenhuma alteração, mas ela estende o JpaRepository<classe que vc tá herdando, tipo do ID>
	Page<Topico> findByCurso_Nome(String nomeCurso, Pageable paginacao); // _ especifica que é um relacionamento (opcional)
}
