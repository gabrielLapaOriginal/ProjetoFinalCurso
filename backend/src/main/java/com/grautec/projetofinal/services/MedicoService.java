package com.grautec.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grautec.projetofinal.entities.Medico;
import com.grautec.projetofinal.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	MedicoRepository repository;
	
	public List<Medico> findAll(){
		return repository.findAll();
	}
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.get();
	}
	
	public Medico insert(Medico obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
