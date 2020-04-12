package br.com.carol.forum.controller.dto;

public class TokenDto {
	
	private String token;
	private String tipo;

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
		
	}
	
	//getters

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
