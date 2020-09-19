package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.FilmeService;

/** @author GILDO */

@RestController
@RequestMapping("/filmes")
public class FilmeController implements Controller<Filme>{
	
	@Autowired
	private FilmeService service;

	@Override
	public ResponseEntity<List<Filme>> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/{busca}")	
	@Override
	public ResponseEntity<Filme> buscar(String busca) {
		Filme filme = this.service.buscarFavorito(busca);		
//		if(filme.getTitulo().length() > 0) 			
		return ResponseEntity.ok(filme);
		
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
