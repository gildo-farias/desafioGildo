package com.goat.desafioGildo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goat.desafioGildo.models.Favoritos;
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
	public Favoritos buscar(Long id) {
		// TODO Auto-generated method stub
		return null;		
	}

	@Override
	public Favoritos salvar(Long id_filme, String login_usuario) {
		Favoritos favorito = new Favoritos(id_filme, login_usuario);		
		return favoritosRepository.save(favorito);		
	}

	@Override
	public boolean deletar(Long id_filme, String login_usuario) {	
		List<Favoritos> favoritosList = favoritosRepository.findAllFavoritosByUsuario(id_filme, login_usuario);		
		if(favoritosList.size()>0) {
			favoritosRepository.deleteAll(favoritosList);
			return true;			
		}else {
			return false;			
		}				
		
	}

	

	

}
