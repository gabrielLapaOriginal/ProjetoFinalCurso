package com.grautec.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grautec.projetofinal.entities.Cliente;
import com.grautec.projetofinal.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public Cliente login(String email, String senha) {
		return repository.buscarLogin(email, senha);
	}
	
}
