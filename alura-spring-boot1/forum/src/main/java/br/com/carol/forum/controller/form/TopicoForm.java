package br.com.carol.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.carol.forum.model.Curso;
import br.com.carol.forum.model.Topico;
import br.com.carol.forum.repository.CursoRepository;


public class TopicoForm {
	
	@NotNull //não permite que o campo seja nulo
	@NotEmpty //não pode ser vazio
	@Length(min = 5)//tamanho mínimo do campo
	private String titulo;
	
	@NotNull //não permite que o campo seja nulo
	@NotEmpty //não pode ser vazio
	@Length(min = 10)//tamanho mínimo do campo
	private String mensagem;
	
	@NotNull //não permite que o campo seja nulo
	@NotEmpty //não pode ser vazio
	@Length(min = 5)//tamanho mínimo do campo
	private String nomeCurso;
	
	//getters and setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico (titulo, mensagem, curso);
	}
	
	

}
