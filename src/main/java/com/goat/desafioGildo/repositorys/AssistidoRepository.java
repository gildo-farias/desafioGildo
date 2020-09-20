package com.goat.desafioGildo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goat.desafioGildo.models.Assistido;

public interface AssistidoRepository extends JpaRepository<Assistido, Long>{
	
	@Query(value = "SELECT * FROM assistido WHERE login_usuario = :login", nativeQuery = true)
	List<Assistido> findAllByUsuario(@Param("login") String login_usuario);

}
