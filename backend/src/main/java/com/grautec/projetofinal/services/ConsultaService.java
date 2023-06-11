package com.grautec.projetofinal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grautec.projetofinal.entities.Consulta;
import com.grautec.projetofinal.entities.ConsultaDTO;
import com.grautec.projetofinal.entities.Medico;
import com.grautec.projetofinal.repositories.ConsultaRepository;
import com.grautec.projetofinal.repositories.MedicoRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository repository;
	
	@Autowired
	MedicoRepository medRep;
	
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
	
	public ConsultaDTO consultasPaciente(Integer id){
		List<Consulta> list = repository.findByClienteId(id);
		List<Medico> medicos = new ArrayList<>();
		
		for(Consulta c : list) {
			int i = c.getMedicoId();
			Optional<Medico> m = medRep.findById(i);
			medicos.add(m.get());
		}
		
		ConsultaDTO c = new ConsultaDTO();
		
		c.setConsultas(list);
		c.setMedicos(medicos);
		
		return c;
		
	}
	
}
