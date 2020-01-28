package com.collection.exemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExemploLista
{
    public static void main( String[] args )
    {
    	
    	String[] lista= new String[3];
    	
      //Coleções/Collections.
    	
    	List<String> lista2= new ArrayList<String>();
    	lista2.add("marcelo");
    	lista2.add("Lucas");
    	lista2.add("Leonardo");
    	lista2.add("Suelen");// .add : metodo para adicionar itens a lista 
    	
    	lista2.remove("Suelen");//.remove: metodo para remover dados da lista podendo ser indice ou objeto.
    	//lista2.clear(); //Limpar lista
    	System.out.println(lista2.size());// .size metodo para apresentar o tamanho da lista.
    	
    	for (String i : lista2) {// estrutura de apresentação de dados da lista.
			System.out.println(i);
		}
    	
    	System.out.println("\n----------------------------------------\n");
    	
    	Iterator<String> listIterator = lista2.iterator();
    	while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
    	
    	
    	
    	
    }
}

