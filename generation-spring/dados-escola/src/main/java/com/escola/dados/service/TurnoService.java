package com.escola.dados.service;

import java.util.List;

import com.escola.dados.entity.Turno;

//No service é interface tb
public interface TurnoService {
	Turno insertOrUpdate(Turno entity);
	
	void delete(int id);
	List<Turno> getAll();
	Turno getById(int id);
	List<Turno> getAllByName(String nome);
	Turno getByName(String nome);
	
}
