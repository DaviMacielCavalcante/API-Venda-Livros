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

import com.apiVendasLivros.entities.ItemPedido;
import com.apiVendasLivros.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itempedidos")
public class ItemPedidoResource {

	@Autowired
	private ItemPedidoService pedidosService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ItemPedido> findById(@PathVariable Integer id){
		
		ItemPedido obj = pedidosService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ItemPedido obj) {
		
		ItemPedido itens = pedidosService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(itens).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
}
