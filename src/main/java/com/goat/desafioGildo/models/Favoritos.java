package com.goat.desafioGildo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favoritos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long id_filme;
	private String login_usuario;	

	public Favoritos(Long id_filme, String login_usuario) {
		super();
		this.id_filme = id_filme;
		this.login_usuario = login_usuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_filme() {
		return id_filme;
	}
	public void setId_filme(Long id_filme) {
		this.id_filme = id_filme;
	}
	public String getLogin_usuario() {
		return login_usuario;
	}
	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}

}
