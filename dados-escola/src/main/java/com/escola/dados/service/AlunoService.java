package com.escola.dados.service;

import java.util.List;

import com.escola.dados.entity.Aluno;

//No service é interface tb
public interface AlunoService {
	
	Aluno insertOrUpdate(Aluno entity);
	
	void delete(int id);
	
	List<Aluno>getAll();
	
	Aluno getById(int id);
	
	List<Aluno> getAllByName(String nome);
	
	Aluno getByName(String nome);
	
}
