package com.goat.desafioGildo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goat.desafioGildo.models.Favoritos;

public interface FavoritoRepository extends JpaRepository<Favoritos, Long>{
	
	@Query(value = "SELECT * FROM favoritos WHERE login_usuario = :login", nativeQuery = true)
	List<Favoritos> findAllByUsuario(@Param("login") String login_usuario);

}
