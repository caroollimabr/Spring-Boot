package com.generation.escola.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.escola.model.Aluno;
import com.generation.escola.service.AlunoService;
import com.generation.escola.service.impl.AlunoServiceImpl;

@CrossOrigin("*")
@RestController
public class AlunoController {
	AlunoService alunoService = new AlunoServiceImpl(); 
	
	@GetMapping("/aluno/")
	public List<Aluno> getAll(){
		return alunoService.getAll();
	}
	
	@GetMapping("/aluno/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable int id) {
		Aluno aluno = alunoService.getById(id);
		
		if(aluno == null)
			ResponseEntity.notFound();
		
		return ResponseEntity.ok(aluno);
	}
	
	/*@GetMapping("/Auth/{login}/{senha}")
	public void login(@PathVariable String login, @PathVariable String senha) {
		
	}*/
	
	
	@PostMapping("/aluno/")
	public ResponseEntity<Aluno>  insert(@RequestBody Aluno aluno) {
		if(aluno.getId() != 0)
			return ResponseEntity.badRequest().body(aluno);
		
		alunoService.insert(aluno);		
		return ResponseEntity.ok(aluno);
	}
	
	@PutMapping("/aluno/")
	public Aluno alterar(@RequestBody Aluno aluno) {
		alunoService.update(aluno);
		return aluno;
	}
	
	
	@DeleteMapping("/aluno/{id}")
	public void delete(@PathVariable int id) {
		alunoService.delete(id);
	}
	
	
	
	
	
	
	
	
	
}
