package com.goat.desafioGildo.services;

import java.util.List;

import com.goat.desafioGildo.models.Filme;

/** @author GILDO */

public interface ServiceInterface<T> {
	
	public List<T> listar(String login_usuario);
	
	public T buscar(String busca);
	
	public T salvar(Filme filme, String login_usuario);
	
	public T alterar(T object);	
	
	public void deletar(Long id);

}
