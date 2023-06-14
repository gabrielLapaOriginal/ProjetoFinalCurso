package com.grautec.projetofinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grautec.projetofinal.entities.Cliente;
import com.grautec.projetofinal.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastroCliente(@RequestBody Cliente obj){
		List<Cliente> list = service.findAll();
		for(Cliente e : list) {
			if(obj.getCPF().equals(e.getCPF())) {
				obj.setCPF("");
				return ResponseEntity.ok().body(obj);
			} else if(obj.getEmail().equals(e.getEmail())) {
				obj.setEmail("");
				return ResponseEntity.ok().body(obj);
			}
		}
		Cliente c = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getIdCliente()).toUri();
		return ResponseEntity.created(uri).body(c);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<Cliente> loginCliente(@RequestBody Cliente c){
		Cliente obj = service.login(c.getEmail(), c.getSenha());
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> todosClientes(){
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
