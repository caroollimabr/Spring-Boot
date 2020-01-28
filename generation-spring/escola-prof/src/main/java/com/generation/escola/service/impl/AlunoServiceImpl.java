package com.generation.escola.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.generation.escola.model.Aluno;
import com.generation.escola.service.AlunoService;

public class AlunoServiceImpl implements AlunoService {
	static List<Aluno> alunos = new ArrayList<Aluno>();
	private static int incr = 0;
	
	@Override
	public Aluno insert(Aluno aluno) {
		incr++;
		aluno.setId(incr);
		this.alunos.add(aluno);
		return aluno;
	}

	@Override
	public Aluno update(Aluno aluno) {
		
		Aluno aux = getById(aluno.getId());
		
		if(aux != null) { //Se encontrei o registro com o mesmo ID
			aux.setNome(aluno.getNome());
			aux.setRa(aluno.getRa());
		}
		
		return aux;
		
		/*for (Aluno aux : alunos) {
			if(aux.getId() == aluno.getId()) {
				aux.setNome(aluno.getNome());
				aux.setRa(aluno.getRa());
				
				return aux;
			}
		}
		return null;*/
	}

	@Override
	public void delete(Aluno aluno) {
		delete(aluno.getId());
	}

	@Override
	public void delete(int id) {
		int posicao = -1;
		for (int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getId() == id) {
				posicao = i;
				break;
			}
		}
		if(posicao >= 0)
			this.alunos.remove(posicao);
		
	}

	@Override
	public Aluno getById(int id) {
		for (Aluno aluno : alunos) {
			if(aluno.getId() == id) {
				return aluno;
			}
		}
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		return alunos;
	}
	
}
