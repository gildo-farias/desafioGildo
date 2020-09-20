package com.goat.desafioGildo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.goat.desafioGildo.models.Filme;
import com.goat.desafioGildo.models.POJOS.FilmePOJO;
import com.goat.desafioGildo.repositorys.FilmeRepository;
import reactor.core.publisher.Mono;
/** @author GILDO */

@Service
public class FilmesService {
	@Autowired
	private WebClient webClient;
	@Autowired
	private FilmeRepository filmeRepository;	
	
	private Filme externaAPI(String busca) {
		Filme filme = new Filme();
		Mono<FilmePOJO> monoFilme = this.webClient.method(HttpMethod.GET).uri("/?t={busca}&apikey=fa032f7f", busca).retrieve().bodyToMono(FilmePOJO.class);
		
		monoFilme.subscribe(data -> {			
			filme.setTitulo(data.title);
			filme.setElenco(data.actors);
			filme.setSinopse(data.plot);			
		});			
		
		monoFilme.block();
		return filme;
	}
	
	public Filme buscarFilme(String busca) {
		Filme filme = new Filme();		
		for (Filme f : BuscasRecentes()) {
			if(f.getTitulo().toLowerCase().contains(busca.toLowerCase()))
			filme = f;			
		}
		
		if(filme.getId() == null) {
			filme = externaAPI(busca);
			if(filme.getSinopse().length()>0) {
				filmeRepository.save(filme);
			}
		}		
		
		return filme;		
	}
	
	public List<Filme> BuscasRecentes() {
		return filmeRepository.findAll();
	}

}
