package com.goat.desafioGildo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goat.desafioGildo.models.Assistido;
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
	public Assistido buscar(Long id) {
		// TODO Auto-generated method stub
		return null;		
	}

	@Override
	public Assistido salvar(Long id_filme, String login_usuario) {
		Assistido assistido = new Assistido(id_filme, login_usuario);		
		return assistidoRepository.save(assistido);	
	}

	@Override
	public boolean deletar(Long id_filme, String login_usuario) {	
		List<Assistido> assistidosList = assistidoRepository.findAllAssistidosByUsuario(id_filme, login_usuario);		
		if(assistidosList.size()>0) {
			assistidoRepository.deleteAll(assistidosList);
			return true;			
		}else {
			return false;			
		}				
		
	}
	

}
