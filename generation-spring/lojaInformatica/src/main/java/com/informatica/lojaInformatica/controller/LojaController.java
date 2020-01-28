package com.informatica.lojaInformatica.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.lojaInformatica.model.Loja;
import com.informatica.lojaInformatica.service.LojaService;
import com.informatica.lojaInformatica.service.impl.LojaServiceImpl;

@CrossOrigin("*")
@RestController
public class LojaController {
	LojaService lojaService = new LojaServiceImpl();
	@GetMapping("/loja/")
	public List<Loja> getAll(){
		return lojaService.getAll();
	}
	
	@GetMapping("/loja/{id}")
	public ResponseEntity<Loja> getById(@PathVariable int id){
		Loja loja = lojaService.getById(id);
		if(loja == null)
			ResponseEntity.notFound();
		
		return ResponseEntity.ok(loja);
	}
	
	@PostMapping("/loja/")
	public ResponseEntity<Loja> insert(@RequestBody Loja loja){
		if(loja.getId() != 0)
			return ResponseEntity.badRequest().body(loja);
		
		lojaService.insert(loja);
		return ResponseEntity.ok(loja);
		
	}
	
	@PutMapping("/loja/")
	public Loja alterar(@RequestBody Loja loja) {
		lojaService.update(loja);
		return loja;
	}
	
	@DeleteMapping("/loja/{id}")
	public void delete (@PathVariable int id) {
		lojaService.delete(id);
	}
}
