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

import com.goat.desafioGildo.models.Assistido;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.services.AssistidosService;
import com.goat.desafioGildo.services.FilmesService;
import com.goat.desafioGildo.services.UsuarioService;
/** @author GILDO */

@RestController
@RequestMapping("/assistidos")
public class AssistidosController implements Controller<Filme> {
	
	@Autowired
	private AssistidosService assistidosService;
	@Autowired
	private FilmesService filmesService;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{username}")
	@Override
	public ResponseEntity<List<Filme>> listar(String username) {	
		if(usuarioService.findUser(username) != null) {
			List<Assistido> assistidosList = assistidosService.listar(username);
			List<Filme> filmesList = new ArrayList<Filme>();
			
			for (Assistido assistido : assistidosList) {
				filmesList.add(filmesService.findFilmeById(assistido.getId_filme()));			
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
			assistidosService.salvar(object.getId(), username);
			return new ResponseEntity<Filme>(object, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}

	@DeleteMapping("/{username}/{id_filme}")
	@Override
	public ResponseEntity<Filme> deletar(String username, Long id_filme) {		
		if(usuarioService.findUser(username) != null) {
			if(assistidosService.deletar(id_filme, username))
			return new ResponseEntity<>(HttpStatus.OK);			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}

	

	

	
	

}
