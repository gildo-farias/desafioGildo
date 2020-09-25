package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.FilmesService;

/** @author GILDO */

@RestController
@RequestMapping("/filmes")
public class FilmesController{
	
	@Autowired
	private FilmesService filmesService;
	
	@GetMapping("")	
	public ResponseEntity<List<Filme>> listar() {
		List<Filme> filmesRecentes = this.filmesService.listarFilmes();
		if(filmesRecentes.size() > 0) 
			return new ResponseEntity<List<Filme>>(filmesRecentes, HttpStatus.OK);		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{busca}")		
	public ResponseEntity<Filme> buscar(@PathVariable(name = "busca") String busca) {
		Filme filme = this.filmesService.buscarFilme(busca);
		if(filme.getId() != null)
			return new ResponseEntity<Filme>(filme, HttpStatus.OK);		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}			

}
