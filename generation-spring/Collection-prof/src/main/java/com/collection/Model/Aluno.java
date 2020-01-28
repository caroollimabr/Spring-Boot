package com.collection.Model;

public class Aluno {
	private int ra;
	private String nome;
	private double nota;
	
	public Aluno(int ra, String nome, double nota) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.nota = nota;
	}
	
	public int getRa() {
		return ra;
	}
	public String getNome() {
		return nome;
	}
	public double getNota() {
		return nota;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", nota=" + nota + "]";
	}
	
}
