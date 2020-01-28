package br.com.professorisidro.tokenization.model;

public class Aluno {

	private int ra;
	private String nome;
	private String email;
	
	
	public Aluno(int ra, String nome, String email) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.email = email;
	}
	
	public Aluno() {
		
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
