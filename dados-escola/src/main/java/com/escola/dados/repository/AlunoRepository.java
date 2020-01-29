package com.escola.dados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.escola.dados.entity.Aluno;

//interface: interage como banco de dados
//CrudRepository: interface do Spring
public interface AlunoRepository extends CrudRepository<Aluno, Integer> { //Integer é o tipo de id
	List<Aluno> findAllByNome(String nome);
	Aluno findAlunoByNome(String nome);

}
