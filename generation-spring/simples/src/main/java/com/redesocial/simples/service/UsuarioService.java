package com.redesocial.simples.service;

import java.util.List;

import com.redesocial.simples.entity.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAll();
	Usuario getById(int id);
	Usuario insertOrUpdate(Usuario usuario);
	void delete(int id);
	List<Usuario>insertOrUpdateAll(List<Usuario> usuarios);

}
