package com.electronicscompany.electronics.model;

public class Computadores extends Eletronicos {
	private int tela;
	
	public Computadores(String nome, double valor, int estoque, int tela) {
		super(nome, valor, estoque); //pegando da classe super
		this.tela = tela;
	}

	public int getTela() {
		return tela;
	}

	public void setTela(int tela) {
		this.tela = tela;
	}
	
	
}
