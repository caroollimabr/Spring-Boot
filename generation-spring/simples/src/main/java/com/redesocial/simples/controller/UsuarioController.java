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

import com.redesocial.simples.entity.Usuario;
import com.redesocial.simples.service.UsuarioService;


//Parte 3 de 3: Adicionar o controlador com a url dos métodos que a gente quer chamar
@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		return ResponseEntity.ok(this.usuarioService.getAll());
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getByIdUsuario(@PathVariable int id){
		return ResponseEntity.ok(usuarioService.getById(id));
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.ok(usuarioService.insertOrUpdate(usuario));
	}
	
	@PostMapping("/usuario/all") // insere todos (um array) os dados de uma vez, incluindo estado
	public ResponseEntity<List<Usuario>> postUsuario(@RequestBody List<Usuario> usuarios){
		return ResponseEntity.ok(usuarioService.insertOrUpdateAll(usuarios));
	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.insertOrUpdate(usuario));
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
		usuarioService.delete(id);
		return ResponseEntity.ok("Usuário removido");
	}
}
