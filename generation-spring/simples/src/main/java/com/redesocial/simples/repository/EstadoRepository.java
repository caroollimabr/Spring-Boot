package com.redesocial.simples.repository;

import org.springframework.data.repository.CrudRepository;


import com.redesocial.simples.entity.Estado;

// comandos do CrudRepository poderão ser usados
public interface EstadoRepository extends CrudRepository<Estado, Integer> {

}
