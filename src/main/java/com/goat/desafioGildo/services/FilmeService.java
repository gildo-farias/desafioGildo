package com.goat.desafioGildo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.models.POJOS.FilmePOJO;

import reactor.core.publisher.Mono;

/** @author GILDO */

@Service
public class FilmeService {
	@Autowired
	private WebClient webClient;
	
	public Filme buscarFavorito(String titulo) {
		Filme filme = new Filme();
		Mono<FilmePOJO> monoFilme = this.webClient.method(HttpMethod.GET).uri("/?t={titulo}&apikey=fa032f7f", titulo).retrieve().bodyToMono(FilmePOJO.class);
		
		monoFilme.subscribe(data -> {			
			filme.setTitulo(data.title);
			filme.setElenco(data.actors);
			filme.setSinopse(data.plot);			
		});			
		
		monoFilme.block();
		
		return filme;
	}
	
//	public Filme salvarFavorito
		

}
