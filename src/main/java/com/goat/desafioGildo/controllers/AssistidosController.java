package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@Override
	public ResponseEntity<List<Filme>> listar(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Filme> buscar(String busca, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Filme> salvar(Filme object, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
