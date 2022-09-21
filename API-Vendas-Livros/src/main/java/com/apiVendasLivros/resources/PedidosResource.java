package com.apiVendasLivros.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiVendasLivros.entities.Pedidos;
import com.apiVendasLivros.services.PedidosService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResource {

	@Autowired
	private PedidosService pedidosService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedidos> findById(@PathVariable Integer id){
		
		Pedidos obj = pedidosService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedidos obj) {
		
		Pedidos livros = pedidosService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(livros).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
}
