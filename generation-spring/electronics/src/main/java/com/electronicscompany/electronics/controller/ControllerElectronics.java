package com.electronicscompany.electronics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicscompany.electronics.model.Computadores;
import com.electronicscompany.electronics.model.Smartphones;
import com.electronicscompany.electronics.model.Televisoes;

@RestController
public class ControllerElectronics {
	
	
	List<Computadores> listaComputadores = new ArrayList<Computadores>();
	List<Televisoes> listaTelevisoes = new ArrayList<Televisoes>();
	List<Smartphones> listaSmartphones = new ArrayList<Smartphones>();
	
	
	
	@GetMapping("/listacomputadores")
	public  List<Computadores> getAllComputadores(){
		
		listaComputadores.add(new Computadores ("Acer-xyz4", 4500.0, 10, 14));
		listaComputadores.add(new Computadores ("Lenovo-iwxs62723", 3285.9, 8, 14));
		listaComputadores.add(new Computadores ("HP-uwg8783", 2901.1, 3, 13));
		listaComputadores.add(new Computadores ("Toshiba-Sattelite72", 3809.7, 7, 16));
		listaComputadores.add(new Computadores ("Dell-cdwh823409", 3450.0, 9, 17));
		
		return listaComputadores;
	}
	
	@GetMapping("/listatelevisoes")
	public List<Televisoes> getAllTelevisoes(){
		listaTelevisoes.add(new Televisoes ("LG-jhd77", 1300.9, 4, 29));
		listaTelevisoes.add(new Televisoes ("Sharp-tw624", 1000.9, 8, 29));
		listaTelevisoes.add(new Televisoes ("Samsung-hgeg65", 799.9, 10, 44));
		listaTelevisoes.add(new Televisoes ("Toshiba-62fswh", 1549.9, 2, 39));
		listaTelevisoes.add(new Televisoes ("CCE-gt6", 1240.9, 10, 15));
		
		
		return listaTelevisoes;
	}
	
	@GetMapping("/listasmartphones")
	public List<Smartphones> getAllSmartphones(){
		listaSmartphones.add(new Smartphones ("Samsung", 799.9, 5, 7));
		listaSmartphones.add(new Smartphones ("LG-jh75", 1375.8, 5, 8));
		listaSmartphones.add(new Smartphones ("Multilaser-h99", 349.9, 5, 6));
		listaSmartphones.add(new Smartphones ("Motorola-g3", 759.9, 5,6));
		listaSmartphones.add(new Smartphones ("Samsung-j7", 1280.9, 5, 7));
		
		return listaSmartphones;
	}

}
