package com.informatica.lojaInformatica.service;

import java.util.List;

import com.informatica.lojaInformatica.model.*;

public interface LojaService {
	Loja insert (Loja loja);
	
	Loja update (Loja loja);
	
	void delete (Loja loja);
	
	void delete(int id);
	
	Loja getById(int id);
	
	List<Loja> getAll();
	
}
