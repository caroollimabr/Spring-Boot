package com.escola.dados.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity //entidade do banco de dados (tabela)
public class Turma {

	@Id //atributo é a Primary Key da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurma;
	@ManyToOne
	private Turno idTurno;
	@Column(length = 255)
	private String nome;
	private String descricao;
	
	//getters and setters
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public Turno getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Turno idTurno) {
		this.idTurno = idTurno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
