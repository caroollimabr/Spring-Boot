package com.escola.dados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dados.entity.Turma;
import com.escola.dados.repository.TurmaRepository;
import com.escola.dados.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Override
	public Turma insertOrUpdate(Turma entity) {
		Turma turmaSalva = this.repository.save(entity);
		return turmaSalva;
	}
	
	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
	}
	
	@Override
	public List<Turma> getAll(){
		return(List<Turma>)this.repository.findAll();
		
	}
	
	@Override
	public Turma getById(int id) {
		return this.repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Turma> getAllByName(String nome){
		return (List<Turma>)this.repository.findAllByNome(nome);
	}
	
	@Override
	public Turma getByName(String nome) {
		return this.repository.findTurmaByNome(nome);
	}
}
