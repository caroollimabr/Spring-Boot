package com.escola.dados.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //entidade do banco de dados (tabela)
public class Turno {
	
	@Id //atributo é a Primary Key da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTurno;
	@Column(length = 30)
	private String nome;
	
	//getters and setters
	public int getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
