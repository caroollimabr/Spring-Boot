package br.com.carol.forum.controller;

import java.net.URI;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.carol.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.carol.forum.controller.dto.TopicoDto;
import br.com.carol.forum.controller.form.AtualizacaoTopicoForm;
import br.com.carol.forum.controller.form.TopicoForm;
import br.com.carol.forum.model.Topico;
import br.com.carol.forum.repository.CursoRepository;
import br.com.carol.forum.repository.TopicoRepository;

@RestController //Já assume que todo método vai ter um @ResponseBody (pede o retorno no corpo do site)
@RequestMapping("/topicos") //pede o mapeamento pra URL (mapeia um endpoint)
public class TopicosController {
	
	@Autowired //injeção da dependência repository
	private TopicoRepository topicoRepository;
	
	@Autowired //injeção da dependência repository
	private CursoRepository cursoRepository;
	
	@GetMapping //para receber as infos cadastradas
	@Cacheable (value = "listaDeTopicos") //informação armazenável
	public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) { // método lista tem parâmetros de URL que não são necessariamente obrigatórios, por isso @RequestParam (required = false)
		//Pageable: interface para paginação; como procurar: http://localhost:8080/topicos?page=0&size=10&sort=id.asc(ou &sort=dataCriacao.desc, por exemplo)
		
		if (nomeCurso == null) {
			Page<Topico> topicos = topicoRepository.findAll(paginacao); //Page<Topico>: vc precisa saber em que pg vc está e qtos elementos em cada pg, não é só uma lista
			//conversao de topico para topicoDto
			return TopicoDto.converter(topicos); 
		} else {
			Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao); //pesquisa por nome dá para ser feita se gerado o método na interface
			//conversao de topico para topicoDto
			return TopicoDto.converter(topicos); 
		}
		
		
	}
		
	@PostMapping //para cadastrar as infos: criar tópicos
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true) //expulsão de dados para atualizar o cache
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) { /*ResponseEntity é o que retorna o código 201, responsável por dar tudo certo e pela criação de um novo recurso.
		@RequestBody - que essa info fique no conteúdo; Enquanto TopicoDto vai mostrar as infos, TopicoForm vai receber as infos
		@Valid - se algum campo for inválido, vai retornar 400*/
		
		
		
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); //Uri: cabeçalho que o 201 devolve com o novo recurso
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) { //@PathVariable - isso é uma variável da URL e devolve o resultado correto
		Optional<Topico> topico = topicoRepository.findById(id); //optional: pode ser que haja um registro do que vc está pedindo ou não
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get())); //se existir, ok
		} 
		return ResponseEntity.notFound().build(); //se não existir, 404
	}
	
	@PutMapping("/{id}")
	@Transactional //avisa para o Spring commitar a transação (atualização) no final
	@CacheEvict(value = "listaDeTopicos", allEntries = true) //expulsão de dados para atualizar o cache
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Optional<Topico> optional = topicoRepository.findById(id); //optional: pode ser que haja um registro do que vc está pedindo ou não
		if (optional.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDto(topico)); //se existir, ok
		} 
		return ResponseEntity.notFound().build(); //se não existir, 404
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true) //expulsão de dados para atualizar o cache
	public ResponseEntity<TopicoDto> remover(@PathVariable Long id){
		Optional<Topico> optional = topicoRepository.findById(id); //optional: pode ser que haja um registro do que vc está pedindo ou não
		if (optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build(); //se existir, delete e ok
		}
		
		return ResponseEntity.notFound().build(); //se não existir, 404
	}
	

}

//CACHE DEVE SER USADO EM TABELAS POUCO ATUALIZADAS. NÃO USE EM TODO LUGAR.
