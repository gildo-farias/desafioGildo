package com.goat.desafioGildo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goat.desafioGildo.models.Usuario;
import com.goat.desafioGildo.repositorys.UsuarioRepository;

@Service
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario: " + login + " não encontrado!");
		}		
		return usuario;
	}

}