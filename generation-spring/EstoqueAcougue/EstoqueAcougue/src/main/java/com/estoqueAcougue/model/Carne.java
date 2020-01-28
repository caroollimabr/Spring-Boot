package com.estoqueAcougue.model;
//passo 1 criar os meus atributos.
public class Carne {
	private String nome;
	private int quantidade;
	private double preco;
	
	public Carne() {
		super();
	}

	public Carne(String nome, int quantidade, double preco) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	//passo 2 criar os meus meus metodos de acesso Get/Set.
	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
