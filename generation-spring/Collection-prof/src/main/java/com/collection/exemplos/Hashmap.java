package com.collection.exemplos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.collection.Model.Aluno;

public class Hashmap {
	public static void main(String[] args) {
		Map<Integer, Aluno> listaDeAluno = new HashMap<Integer, Aluno>();

		listaDeAluno.put(1, new Aluno(123, "Mateus", 9.8));
		listaDeAluno.put(2, new Aluno(124, "Luciano", 8.8));
		listaDeAluno.put(3, new Aluno(125, "Clara", 9.8));
		listaDeAluno.put(4, new Aluno(126, "Mayara", 8.8));
		if (!listaDeAluno.containsKey(4)) {
			listaDeAluno.put(4, new Aluno(126, "Mayara", 10.0));
		}

		System.out.println(listaDeAluno.get(4).getNome() + " " + listaDeAluno.get(4).getNota());
		System.out.println(listaDeAluno.remove(2));

		for (Entry<Integer, Aluno> aluno : listaDeAluno.entrySet()) {
			System.out.println(aluno.getKey() + " " + aluno.getValue().getNome() + " " + aluno.getValue().getNota());
		}
	}
}
