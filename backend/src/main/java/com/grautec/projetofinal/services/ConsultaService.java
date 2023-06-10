package com.grautec.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grautec.projetofinal.entities.Consulta;
import com.grautec.projetofinal.repositories.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository repository;
	
	public List<Consulta> findAll(){
		return repository.findAll();
	}
	
	public Consulta findById(Integer id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.get();
	}
	
	public Consulta insert(Consulta obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Consulta update(Integer id, Consulta obj) {
		Consulta att = repository.findById(id).get();
		
		att.setDataDaConsulta(obj.getDataDaConsulta());
		att.setHoraDaConsulta(obj.getHoraDaConsulta());
		
		return att;
	}
	
	public List<Consulta> consultasPaciente(Integer id){
		return repository.consultasPacienteId(id);
	}
	
}
