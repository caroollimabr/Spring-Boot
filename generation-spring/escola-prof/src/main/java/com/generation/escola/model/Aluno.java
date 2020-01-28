package com.generation.escola.model;

public class Aluno {
	//Atributos
	private int id;
	private String nome;
	private int ra;
	
	//Construtores
	public Aluno() {
		super();
	}
	
	public Aluno(String nome, int ra) {
		super();
		this.nome = nome;
		this.ra = ra;
	}
	
	//Propriedades
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public int getRa() {
		return ra;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
}
