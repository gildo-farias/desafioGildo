package com.goat.desafioGildo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goat.desafioGildo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByLogin(String login);
}
