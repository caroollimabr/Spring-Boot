package com.banco.cliente.service;

import java.util.List;

import com.banco.cliente.model.*;

public interface ClienteService {
	Cliente insert(Cliente cliente);
	
	Cliente update (Cliente cliente);
	
	void delete(Cliente cliente);
	
	void delete(int id);
	
	Cliente getById(int id);
	
	List<Cliente> getAll();
}
