package com.apiVendasLivros.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiVendasLivros.entities.Enderecos;
import com.apiVendasLivros.services.EnderecosService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecosResource {
	
	@Autowired
	private EnderecosService enderecosService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Enderecos> findById(@PathVariable Integer id){
		
		Enderecos endereco = enderecosService.findById(id);
		
		return ResponseEntity.ok().body(endereco);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Enderecos obj){
		
		Enderecos novoEndereco = enderecosService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(novoEndereco.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Enderecos obj, @PathVariable Integer id) {
		
		obj.setId(id);
		
		obj = enderecosService.update(id, obj);
		
		return ResponseEntity.noContent().build();		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		
		enderecosService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
