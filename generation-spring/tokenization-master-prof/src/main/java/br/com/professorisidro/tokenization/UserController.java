package br.com.professorisidro.tokenization;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.tokenization.model.Aluno;
import br.com.professorisidro.tokenization.model.Token;
import br.com.professorisidro.tokenization.model.Usuario;
import br.com.professorisidro.tokenization.util.Autenticator;

@RestController
@CrossOrigin("*")
public class UserController {

	@PostMapping("/autenticate")
	public ResponseEntity<Token> autenticate(@RequestBody Usuario usuario) {
		System.out.println(usuario.getUsername());
		System.out.println(usuario.getPassword());
		if (usuario.getUsername().equals("user") && usuario.getPassword().equals("1234")) {
			System.out.println(Autenticator.encode(usuario));
			return ResponseEntity.ok(new Token(Autenticator.encode(usuario)));
		}
		return ResponseEntity.status(403).build();
	}

	@GetMapping("/alunos/all")
	public ResponseEntity<ArrayList<Aluno>> getAlunos(@RequestParam String token) {
		try {
			if (Autenticator.isValid(token)) {
				ArrayList<Aluno> lista = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					lista.add(new Aluno(i, "Aluno " + i, "aluno" + i + "@aluno.com.br"));
				}
				return ResponseEntity.ok(lista);
			}
			return ResponseEntity.status(403).build();
		} catch (Exception ex) {
			return ResponseEntity.status(400).build();
		}
	}
}
