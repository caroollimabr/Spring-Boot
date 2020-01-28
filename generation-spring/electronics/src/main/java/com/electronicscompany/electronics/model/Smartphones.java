package com.electronicscompany.electronics.model;

public class Smartphones extends Eletronicos {
	private int tamanho;

	public Smartphones(String nome, double valor, int estoque, int tamanho) {
		super(nome, valor, estoque);
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
