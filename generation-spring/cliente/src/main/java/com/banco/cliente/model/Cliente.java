package com.banco.cliente.model;

public class Cliente {
	
	private String cpf;
	private String nome;
	private int id;
	
	//Constructors
	
	public Cliente() {
		super();
	}
	
	public Cliente(String cpf, String nome, int id) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.id = id;
	}
	
	//Getters and Setters

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
