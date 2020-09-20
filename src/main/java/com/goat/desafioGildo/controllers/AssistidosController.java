package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Assistido;
import com.goat.desafioGildo.services.AssistidosService;
import com.goat.desafioGildo.services.FilmesService;
/** @author GILDO */

@RestController
@RequestMapping("/assistido")
public class AssistidosController implements Controller<Assistido> {
	
	@Autowired
	private AssistidosService assistidosService;

	@Override
	public ResponseEntity<List<Assistido>> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Assistido> buscar(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Assistido> salvar(Assistido object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Assistido> alterar(Assistido object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
