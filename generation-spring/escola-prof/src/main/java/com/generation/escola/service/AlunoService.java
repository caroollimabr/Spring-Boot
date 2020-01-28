package com.generation.escola.service;

import java.util.List;

import com.generation.escola.model.*;

public interface AlunoService {
	
	Aluno insert(Aluno aluno);
	
	Aluno update(Aluno aluno);
	
	void delete(Aluno aluno);
	
	void delete(int id);
	
	Aluno getById(int id);
	
	List<Aluno> getAll();
	
}
