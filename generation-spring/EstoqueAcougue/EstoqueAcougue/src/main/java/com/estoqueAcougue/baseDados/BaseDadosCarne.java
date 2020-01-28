package com.estoqueAcougue.baseDados;

import java.util.ArrayList;
import java.util.List;

import com.estoqueAcougue.model.Carne;
//3.1 criar a base de dados e popular
public class BaseDadosCarne {
	private List<Carne> listaCarne= new ArrayList<Carne>();

	public BaseDadosCarne() {
		listaCarne.add(new Carne("Porco", 22, 15.00));
		listaCarne.add(new Carne("Frango", 33, 16.00));
		listaCarne.add(new Carne("Picanha", 5, 33.00));
	}

	public List<Carne> getListaCarne() {
		return listaCarne;
	}

	public void setListaCarne(List<Carne> listaCarne) {
		this.listaCarne = listaCarne;
	}
	
	
}
