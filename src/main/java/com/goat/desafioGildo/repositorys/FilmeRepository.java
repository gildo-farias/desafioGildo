package com.goat.desafioGildo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goat.desafioGildo.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
