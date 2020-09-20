package com.goat.desafioGildo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/** @author GILDO */

public interface Controller<T> {
	
	public ResponseEntity<List<T>> listar();
	
	public ResponseEntity<T> buscar(@PathVariable(name = "busca") String busca);
	
	public ResponseEntity<T> salvar(@RequestBody T object);
	
	public ResponseEntity<T> alterar(@RequestBody T object);	
	
	public void deletar(@PathVariable(name = "id") Long id);
}
