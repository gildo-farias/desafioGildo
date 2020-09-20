package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.FilmesService;

/** @author GILDO */

@RestController
@RequestMapping("/filmes")
public class FilmesController implements Controller<Filme> {
	
	@Autowired
	private FilmesService filmesService;
	
	@GetMapping("/{busca}")
	@Override
	public ResponseEntity<Filme> buscar(String busca) {
		Filme filme = this.filmesService.buscarFilme(busca);
		return ResponseEntity.ok(filme);
	}

	@GetMapping("")
	@Override
	public ResponseEntity<List<Filme>> listar() {
		List<Filme> filmesRecentes = filmesService.BuscasRecentes();
		return ResponseEntity.ok(filmesRecentes);
	}	

	@Override
	public ResponseEntity<Filme> salvar(Filme object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Filme> alterar(Filme object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
