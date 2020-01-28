package com.informatica.lojaInformatica.model;

public class Loja {
	private int id;
	private String nome;
	private double valor;
	
	//construtor
	public Loja() {
		super();
	}

	public Loja(int id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}
