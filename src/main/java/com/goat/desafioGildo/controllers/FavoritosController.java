package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Favoritos;
import com.goat.desafioGildo.services.FavoritosService;
import com.goat.desafioGildo.services.FilmesService;
/** @author GILDO */

@RestController
@RequestMapping("/favoritos")
public class FavoritosController implements Controller<Favoritos>{
	
	@Autowired
	private FavoritosService favoritosService;

	@Override
	public ResponseEntity<List<Favoritos>> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Favoritos> buscar(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Favoritos> salvar(Favoritos object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Favoritos> alterar(Favoritos object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	

}
