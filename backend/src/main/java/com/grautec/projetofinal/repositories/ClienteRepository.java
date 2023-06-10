package com.grautec.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grautec.projetofinal.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("select e from Cliente e where e.email = :email and e.senha = :senha")
	Cliente buscarLogin(String email, String senha);
}
