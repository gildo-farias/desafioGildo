package com.goat.desafioGildo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@GetMapping("/{username}")
	@Override
	public ResponseEntity<List<Filme>> listar(String username) {
		if(usuarioService.findUser(username) != null) {
			List<Favoritos> favoritosList = favoritosService.listar(username);
			List<Filme> filmesList = new ArrayList<Filme>();
			
			for (Favoritos favorito : favoritosList) {
				filmesList.add(filmesService.findFilmeById(favorito.getId_filme()));			
			}	
			return new ResponseEntity<List<Filme>>(filmesList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);			
		}		
	}	
	
	@Override
	public ResponseEntity<Filme> buscar(String busca, String username) {
		// TODO Auto-generated method stub
		return null;
	}	

	@PostMapping("/{username}")	
	@Override
	public ResponseEntity<Filme> salvar(Filme object, String username) {	
		if(object != null && usuarioService.findUser(username) != null) {
			favoritosService.salvar(object.getId(), username);
			return new ResponseEntity<Filme>(object, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}

	@DeleteMapping("/{username}/{id_filme}")
	@Override
	public ResponseEntity<Filme> deletar(String username, Long id_filme) {		
		if(usuarioService.findUser(username) != null) {
			if(favoritosService.deletar(id_filme, username))
			return new ResponseEntity<>(HttpStatus.OK);			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	
}
