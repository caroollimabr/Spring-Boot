package com.escola.dados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dados.entity.Turno;
import com.escola.dados.repository.TurnoRepository;
import com.escola.dados.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {
	
	@Autowired
	private TurnoRepository repository;
	
	@Override
	public Turno insertOrUpdate(Turno entity) {
		Turno alunoSalvo = this.repository.save(entity);
		return alunoSalvo;
	}
	
	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
	}
	
	@Override
	public List<Turno> getAll(){
		return(List<Turno>)this.repository.findAll();
		
	}
	
	@Override
	public Turno getById(int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Turno> getAllByName(String nome){
		return (List<Turno>)this.repository.findAllByNome(nome);
	}
	
	@Override
	public Turno getByName(String nome) {
		return this.repository.findTurnoByNome(nome);
	}
}