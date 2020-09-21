package com.goat.desafioGildo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Assistido;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.AssistidosService;
import com.goat.desafioGildo.services.FilmesService;
/** @author GILDO */

@RestController
@RequestMapping("/assistidos")
public class AssistidosController implements Controller<Filme> {
	
	@Autowired
	private AssistidosService assistidosService;
	@Autowired
	private FilmesService filmesService;

	@GetMapping("/{username}")
	@Override
	public ResponseEntity<List<Filme>> listar(String username) {		
		List<Assistido> assistidosList = assistidosService.listar(username);
		List<Filme> filmesList = new ArrayList<Filme>();
		
		for (Assistido assistido : assistidosList) {
			filmesList.add(filmesService.findFilmeById(assistido.getId_filme()));			
		}
		
		return ResponseEntity.ok(filmesList);		
	}	

	@Override
	public ResponseEntity<Filme> buscar(String busca, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/{username}")
	@Override
	public ResponseEntity<Filme> salvar(Filme object, String username) {
		if(username != null) {
			assistidosService.salvar(object.getId(), username);
		}				
		return ResponseEntity.ok(object);
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub		
	}
	

}
