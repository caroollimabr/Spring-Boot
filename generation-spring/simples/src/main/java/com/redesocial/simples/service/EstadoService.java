package com.redesocial.simples.service;

import java.util.List;

import com.redesocial.simples.entity.Estado;

public interface EstadoService {
	
	//passo 1 de 3: dá os métodos do CrudRepository que vc vai poder chamar
	List<Estado> getAll();
	Estado getById(int id);
	Estado insertOrUpdate(Estado estado);
	void delete(int id);
	List<Estado>insertOrUpdateAll(List<Estado> estados); 

}
