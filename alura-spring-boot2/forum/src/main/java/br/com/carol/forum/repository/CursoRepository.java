package br.com.carol.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carol.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nome);

}
 