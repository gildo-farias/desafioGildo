package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/** @author GILDO */

public interface Controller<T> {
		
	public ResponseEntity<List<T>> listar(@PathVariable(name = "username") String username);
	
	public ResponseEntity<T> buscar(@PathVariable(name = "busca") String busca, @PathVariable(name = "username") String username);
	
	public ResponseEntity<T> salvar(@RequestBody T object, @PathVariable(name = "username") String username);
	
	public ResponseEntity<T> deletar(@PathVariable(name = "username") String username, @PathVariable(name = "id_filme") Long id_filme);
		
}
