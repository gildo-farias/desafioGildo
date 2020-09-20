package com.goat.desafioGildo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goat.desafioGildo.models.Favoritos;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.repositorys.FavoritoRepository;

/** @author GILDO */

@Service
public class FavoritosService implements ServiceInterface<Favoritos>{
	@Autowired
	private FavoritoRepository favoritosRepository;

	@Override
	public List<Favoritos> listar(String login_usuario) {
		return favoritosRepository.findAllByUsuario(login_usuario);
	}

	@Override
	public Favoritos buscar(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Favoritos salvar(Filme filme, String login_usuario) {
		Favoritos favorito = new Favoritos();
		favorito.setId_filme(filme.getId());
		favorito.setLogin_usuario(login_usuario);
		
		return favoritosRepository.save(favorito);		
	}

	@Override
	public Favoritos alterar(Favoritos object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}


}
