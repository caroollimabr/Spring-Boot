package com.redesocial.simples.repository;

import org.springframework.data.repository.CrudRepository;

import com.redesocial.simples.entity.Usuario;

//comandos do CrudRepository poderão ser usados
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
