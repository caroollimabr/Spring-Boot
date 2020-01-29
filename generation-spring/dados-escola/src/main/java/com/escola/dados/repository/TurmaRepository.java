package com.escola.dados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.escola.dados.entity.Turma;

//CrudRepository: interface do Spring
//interface: interage como banco de dados
public interface TurmaRepository extends CrudRepository<Turma, Integer> {
	//Integer é o tipo de id
	List<Turma> findAllByNome(String nome);
	Turma findTurmaByNome(String nome);
	
}
