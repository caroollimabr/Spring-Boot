package com.escola.dados.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity // entidade do banco de dados (tabela)
public class Aluno {

	@Id // atributo é a Primary Key da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAluno;

	@ManyToOne
	private Turma idTurma;

	@Column(length = 255)
	private String nome;

	//getters and setters
	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public Turma getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Turma idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
