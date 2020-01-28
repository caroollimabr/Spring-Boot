package com.collection.exemplos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.collection.Model.Aluno;


public class Iterator {
	public static void main(String[] args) {
		List<Aluno> listaAluno = new ArrayList<Aluno>();// lista de objeto do tipo aluno

		listaAluno.add(new Aluno(123, "Aline", 8.3)); // adicionando dados na listaAlunos
		listaAluno.add(new Aluno(124, "leonardo", 8.5));
		listaAluno.add(new Aluno(125, "Lucas ", 8.3));
		listaAluno.add(new Aluno(126, "Guilherme", 8.2));
		listaAluno.add(new Aluno(126, "Guilherme", 8.2));

		for (Aluno aluno : listaAluno) {// varrendo dados da lista de alunos.
			System.out.println(aluno);
		}

		System.out.println("\n");
		System.out.println("-------------");
		System.out.println("\n");

		Set<Integer> listadealunos2 = new HashSet<Integer>();// Set garante que sua coleção não tenha duplicidade de
																// dados.

		listadealunos2.add(1);
		listadealunos2.add(1);
		listadealunos2.add(2);
		listadealunos2.add(3);
		listadealunos2.add(1);

		for (Integer indice : listadealunos2) {// varrer dados do Set
			System.out.println(indice);
		}
}
}
