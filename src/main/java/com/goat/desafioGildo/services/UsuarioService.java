package com.goat.desafioGildo.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
/** @author GILDO */

import com.goat.desafioGildo.models.Usuario;
import com.goat.desafioGildo.repositorys.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public String getLogin() {
		String currentUserName = new String();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		currentUserName = authentication.getName();
		System.out.println("USUARIO LOGADO: " + currentUserName);
		return currentUserName;
	}
	
	public Usuario findUser(String login_usuario) {
		try {
			Usuario usuario = usuarioRepository.findById(login_usuario).get();
			return usuario;
		} catch (NoSuchElementException e) {
			return null;
		}		
		
	}
	
}
