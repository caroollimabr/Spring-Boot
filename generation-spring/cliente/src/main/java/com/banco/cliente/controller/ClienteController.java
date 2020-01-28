package com.banco.cliente.controller;

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

import com.banco.cliente.model.Cliente;
import com.banco.cliente.service.ClienteService;
import com.banco.cliente.service.impl.ClienteServiceImpl;

@CrossOrigin("*")
@RestController
public class ClienteController {
	ClienteService clienteService = new ClienteServiceImpl();
	
	@GetMapping("/cliente/")
	public List<Cliente> getAll(){
		return clienteService.getAll();
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable int id){
		Cliente cliente = clienteService.getById(id);
		
		if(cliente == null)
			ResponseEntity.notFound();
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/cliente/")
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
		if(cliente.getId() != 0)
			return ResponseEntity.badRequest().body(cliente);
		
		clienteService.insert(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/cliente/")
	public Cliente alterar(@RequestBody Cliente cliente) {
		clienteService.update(cliente);
		return cliente;
	}
	
	@DeleteMapping("/clienyte/{id}")
	public void delete(@PathVariable int id) {
		clienteService.delete(id);
	}
}
