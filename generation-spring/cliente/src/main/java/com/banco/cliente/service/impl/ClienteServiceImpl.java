package com.banco.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.banco.cliente.model.Cliente;
import com.banco.cliente.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	private static int incr = 0;
	
	@Override
	public Cliente insert(Cliente cliente) {
		incr++;
		cliente.setId(incr);
		this.clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente update(Cliente cliente) {
		
		Cliente aux = getById(cliente.getId());
		
		if(aux != null) {
			aux.setNome(cliente.getNome());
			aux.setId(cliente.getId());
		}
		return aux;
	}

	@Override
	public void delete(Cliente cliente) {
		delete(cliente.getId());
		
	}

	@Override
	public void delete(int id) {
		int posicao = -1;
		for (int i = 0; i < this.clientes.size(); i++) {
			if(this.clientes.get(i).getId() == id) {
				posicao = i;
				break;
			}
		}
		if (posicao >= 0)
			this.clientes.remove(posicao);
	}

	@Override
	public Cliente getById(int id) {
		for (Cliente cliente : clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}

	@Override
	public List<Cliente> getAll() {
		return clientes;
	}
	
}
