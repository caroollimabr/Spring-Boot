package com.escola.dados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.escola.dados.entity.Turno;

//Interface - interage com o banco de dados
public interface TurnoRepository extends CrudRepository<Turno, Integer> {
	//Integer é o tipo de id
	List<Turno> findAllByNome(String nome);
	Turno findTurnoByNome(String nome);
	

}
