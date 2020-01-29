package com.redesocial.simples.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redesocial.simples.entity.Estado;
import com.redesocial.simples.entity.Usuario;
import com.redesocial.simples.repository.EstadoRepository;
import com.redesocial.simples.service.EstadoService;


// Passo 2 de 3: Adicione um @Override para cada método que vc vai chamar no Postman

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired // injeção da interface dentro do objeto criado pela Autowired
	private EstadoRepository estadoRepository;

	//btn direito - source - override
	@Override
	public List<Estado> getAll() {
		List<Estado> estados= (List<Estado>)estadoRepository.findAll();
		return estados;
	}

	@Override
	public Estado getById(int id) {
		return estadoRepository.findById(id).orElse(null);
	}

	@Override
	public Estado insertOrUpdate(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@Override
	public List<Estado> insertOrUpdateAll(List<Estado> estados) {
		return (List<Estado>) estadoRepository.saveAll(estados);
	}

	@Override
	public void delete(int id) {
		estadoRepository.deleteById(id);
		
	}
	
	
	
}
