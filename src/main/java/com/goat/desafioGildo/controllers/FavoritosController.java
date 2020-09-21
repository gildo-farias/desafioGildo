package com.goat.desafioGildo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Favoritos;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.FavoritosService;
import com.goat.desafioGildo.services.FilmesService;
import com.goat.desafioGildo.services.UsuarioService;
/** @author GILDO */

@RestController
@RequestMapping("/favoritos")
public class FavoritosController implements Controller<Filme>{
		
	@Autowired	
	private FavoritosService favoritosService;
	@Autowired
	private FilmesService filmesService;  
	@Autowired
	private UsuarioService usuarioService; 

	@GetMapping("")
	@Override
	public ResponseEntity<List<Filme>> listar() {		
		List<Favoritos> favoritosList = favoritosService.listar(usuarioService.getLogin());
		List<Filme> filmesList = new ArrayList<Filme>();
		
		for (Favoritos favorito : favoritosList) {
			filmesList.add(filmesService.findFilmeById(favorito.getId_filme()));			
		}
		
		return ResponseEntity.ok(filmesList);		
	}

	@Override
	public ResponseEntity<Filme> buscar(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/star")
	@Override
	public ResponseEntity<Filme> salvar(Filme object) {		
//		favoritosService.salvar(object, usuarioService.getLogin());		
		return ResponseEntity.ok(object);
	}

	@Override
	public ResponseEntity<Filme> alterar(Filme object) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/unstar")
	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub		
	}	

}
