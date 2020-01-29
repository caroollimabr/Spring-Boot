package com.redesocial.simples.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redesocial.simples.entity.Usuario;
import com.redesocial.simples.repository.UsuarioRepository;
import com.redesocial.simples.service.UsuarioService;


//Passo 2 de 3: Adicione um @Override para cada método que vc vai chamar no Postman

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired // injeção da interface dentro do objeto criado pela Autowired
	private UsuarioRepository usuarioRepository;
	
	//btn direito - override/implement methods
	
	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = (List<Usuario>)usuarioRepository.findAll();
		return usuarios;
	}

	@Override
	public Usuario getById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario insertOrUpdate(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(int id) {
		usuarioRepository.deleteById(id);
		
	}

	@Override
	public List<Usuario> insertOrUpdateAll(List<Usuario> usuarios) {		
		return (List<Usuario>) usuarioRepository.saveAll(usuarios);
	}
		
	
	
	}


