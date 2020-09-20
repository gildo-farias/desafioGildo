package com.goat.desafioGildo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goat.desafioGildo.models.Assistido;
import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.repositorys.AssistidoRepository;

/** @author GILDO */

@Service
public class AssistidosService implements ServiceInterface<Assistido> {
	@Autowired
	private AssistidoRepository assistidoRepository;

	@Override
	public List<Assistido> listar(String login_usuario) {
		return assistidoRepository.findAllByUsuario(login_usuario);
	}

	@Override
	public Assistido buscar(String busca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assistido salvar(Filme filme, String login_usuario) {
		Assistido assistido = new Assistido();
		assistido.setId_filme(filme.getId());
		assistido.setLogin_usuario(login_usuario);
		
		return assistidoRepository.save(assistido);	
	}

	@Override
	public Assistido alterar(Assistido object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
