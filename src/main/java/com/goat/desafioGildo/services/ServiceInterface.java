package com.goat.desafioGildo.services;

import java.util.List;
/** @author GILDO */

public interface ServiceInterface<T> {
	
	public List<T> listar(String login_usuario);
	
	public T buscar(Long id);
	
	public T salvar(Long id_filme, String login_usuario);
		
	public boolean deletar(Long id_filme, String login_usuario);

}
