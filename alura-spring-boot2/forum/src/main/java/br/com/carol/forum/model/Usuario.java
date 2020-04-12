package br.com.carol.forum.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity //diz que é uma entidade
public class Usuario implements UserDetails { //UserDetails (deixa algumas infos públicas, outras privadas

	private static final long serialVersionUID = 1L;
	
	
	@Id //diz que a info é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerar o ID
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	//um usuário pode ter vários perfis e um perfil pode estar atrelado a vários usuários.
	@ManyToMany(fetch = FetchType.EAGER) //.EAGER - carrega esses perfis
	private List<Perfil> perfis = new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Unimplemented methods de UserDetails, agora implementados

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.perfis;
	}

	@Override
	public String getPassword() {
	
		return this.senha;
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() { //a conta n tá expirada, por isso deve retornar true
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
