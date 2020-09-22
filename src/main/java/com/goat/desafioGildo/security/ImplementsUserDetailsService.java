package com.goat.desafioGildo.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.goat.desafioGildo.models.Usuario;
import com.goat.desafioGildo.repositorys.UsuarioRepository;
/** @author GILDO */

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario: " + login + " não encontrado!");
		}		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true,  usuario.getAuthorities());
//		return usuario;
	}

}
