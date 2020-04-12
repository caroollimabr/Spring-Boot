package br.com.carol.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id //diz que a info é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerar o ID
	private Long id;
	
	private String nome; //"admin"

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Unimplemented method de GrantedAuthority, agora implementado

	@Override
	public String getAuthority() {

		return nome; //
	}
	
	


}
