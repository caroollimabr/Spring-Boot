package com.escola.dados.service;

import java.util.List;

import com.escola.dados.entity.Turma;

//No service é interface tb
public interface TurmaService {
	
	Turma insertOrUpdate(Turma entity);
	
	void delete(int id);
	List<Turma> getAll();
	Turma getById(int id);
	List<Turma> getAllByName(String nome);
	Turma getByName(String nome);

}
