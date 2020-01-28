package com.estoqueAcougue.Servico;

import com.estoqueAcougue.model.Carne;

public interface IServico {
	// passo 3 criar uma interface e
	//colocar os metodos correspondentes
	void getAllCarne();
	void addCarne(Carne carne);
	void deleteCarne();
}
