package com.redesocial.simples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.simples.entity.Estado;
import com.redesocial.simples.entity.Usuario;
import com.redesocial.simples.service.EstadoService;

//Parte 3 de 3: Adicionar o controlador com a url dos métodos que a gente quer chamar

@RestController
@CrossOrigin("*")
public class EstadoController {

	@Autowired
	EstadoService estadoService;
	
	@GetMapping("/estado")
	public ResponseEntity<List<Estado>> getAllUsuario() {
		return ResponseEntity.ok(this.estadoService.getAll());
	}
	
	@GetMapping("/estado/{id}")
	public ResponseEntity<Estado> getByIdUsuario(@PathVariable int id) {
		return ResponseEntity.ok(estadoService.getById(id));
	}
	
	@PostMapping("/estado")
	public ResponseEntity<Estado> postUsuario(@RequestBody Estado estado) {
		return ResponseEntity.ok(estadoService.insertOrUpdate(estado));
	}
	
	@PostMapping("/estado/all") // insere todos (um array) os dados de uma vez
	public ResponseEntity<List<Estado>> postUsuario(@RequestBody List<Estado> estados){
		return ResponseEntity.ok(estadoService.insertOrUpdateAll(estados));
	}
	
	@PutMapping("/estado")
	public ResponseEntity<Estado> putUsuario(@RequestBody Estado estado) {
		return ResponseEntity.ok(estadoService.insertOrUpdate(estado));
	}
	@DeleteMapping("/estado/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
		estadoService.delete(id);
		return ResponseEntity.ok("Estado removido"); 
	}
	
}
