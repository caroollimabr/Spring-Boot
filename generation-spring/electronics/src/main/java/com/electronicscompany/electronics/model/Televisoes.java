package com.electronicscompany.electronics.model;

public class Televisoes extends Eletronicos {
	
	private int polegadas;

	public Televisoes(String nome, double valor, int estoque, int polegadas) {
		super(nome, valor, estoque);
		this.polegadas = polegadas;
	}

	public int getPolegadas() {
		return polegadas;
	}

	public void setPolegadas(int polegadas) {
		this.polegadas = polegadas;
	}
	
	
}
