package com.grautec.projetofinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grautec.projetofinal.entities.Consulta;
import com.grautec.projetofinal.entities.ConsultaDTO;
import com.grautec.projetofinal.services.ConsultaService;

@RestController
@RequestMapping(value="/consultas")
public class ConsultaResource {

	@Autowired
	ConsultaService service;
	
	@GetMapping(value = "/paciente/{id}")
	public ResponseEntity<ConsultaDTO> consultasPaciente(@PathVariable Integer id){
		ConsultaDTO obj = service.consultasPaciente(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Consulta> marcarConsulta(@RequestBody Consulta obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/consulta/{id}")
	public ResponseEntity<Void> cancelarConsulta(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/consulta/{id}")
	public ResponseEntity<Consulta> alterarConsulta(@PathVariable Integer id, @RequestBody Consulta obj){
		Consulta c = service.update(id, obj);
		return ResponseEntity.ok().body(c);
	}
}
