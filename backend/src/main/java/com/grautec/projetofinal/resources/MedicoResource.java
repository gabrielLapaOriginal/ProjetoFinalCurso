package com.grautec.projetofinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grautec.projetofinal.entities.Medico;
import com.grautec.projetofinal.services.MedicoService;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {

	@Autowired
	MedicoService service;
	
	@GetMapping
	public ResponseEntity<List<Medico>> todosMedicos(){
		List<Medico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Medico> medicoById(@PathVariable Integer id){
		Medico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
