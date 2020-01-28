package com.informatica.lojaInformatica.service.impl;

import java.util.ArrayList;

import java.util.List;

import com.informatica.lojaInformatica.model.Loja;
import com.informatica.lojaInformatica.service.LojaService;

public class LojaServiceImpl implements LojaService {
	static List<Loja> lojas = new ArrayList<Loja>();
	
	private static int incr = 0;
	
	
	@Override
	public Loja insert(Loja loja) {
		incr++;
		loja.setId(incr);
		this.lojas.add(loja);
		return loja;
	}
	
	@Override
	public Loja update(Loja loja) {
		Loja aux = getById(loja.getId());
		
		if(aux != null) {
			aux.setNome(loja.getNome());
			aux.setId(loja.getId());
		}
		return aux;
	}
	@Override
	public void delete(Loja loja) {
		delete(loja.getId());
		
	}
	
	@Override
	public void delete(int id) {
		int posicao = -1;
		for (int i = 0; i < this.lojas.size(); i++) {
			if(this.lojas.get(i).getId() == id) {
				posicao = i;
				break;
			}
		}
		if(posicao >= 0)
			this.lojas.remove(posicao);
	}
	
	@Override
	public Loja getById(int id) {
		for (Loja loja : lojas) {
			if(loja.getId() == id) {
				return loja;
			}
		}
		return null;
	}
	
	@Override
	public List<Loja> getAll() {
		return lojas;
	}

}
