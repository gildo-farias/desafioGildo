package com.goat.desafioGildo.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
/** @author GILDO */

@Service
public class UsuarioService {

	public String getLogin() {
		String currentUserName = new String();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		currentUserName = authentication.getName();
		System.out.println("USUARIO LOGADO: " + currentUserName);
		return currentUserName;
	}
	
}
