package com.goat.desafioGildo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goat.desafioGildo.models.Usuario;
import com.goat.desafioGildo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/novo")
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		if(usuario.getLogin() != null && usuario.getNomeCompleto() != null && usuario.getSenha() != null) {
			if(usuarioService.salvar(usuario) == null)
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);			
		}			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
	}

}
