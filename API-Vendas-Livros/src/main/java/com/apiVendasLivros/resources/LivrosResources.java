package com.apiVendasLivros.resources;

import java.net.URI;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiVendasLivros.entities.Livros;
import com.apiVendasLivros.services.LivrosService;

@RestController
@RequestMapping(value = "/livros")
@Transactional
public class LivrosResources {
	
	@Autowired
	private LivrosService livrosService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livros> findById(@PathVariable Integer id){
		
		Livros obj = livrosService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/isbn/{isbn}", method = RequestMethod.GET)
	public ResponseEntity<Livros> findByIsbn(@PathVariable String isbn){
		
		Livros obj = livrosService.findByIsbn(isbn);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livros>> findAll(){
		
		List<Livros> livros = livrosService.findAll();
		
		return ResponseEntity.ok().body(livros);
	}
	
	@RequestMapping(value = "/autor/{autor}" ,method = RequestMethod.GET)
	public ResponseEntity<List<Livros>> findByAutor(@PathVariable String autor){
		
		List<Livros> livros = livrosService.findByAutor(autor);
		
		return ResponseEntity.ok().body(livros);
	}
	
	@RequestMapping(value = "/genero/{genero}", method = RequestMethod.GET)
	public ResponseEntity<List<Livros>> findByGenero(@PathVariable String genero){
		
		List<Livros> livros = livrosService.findByGenero(genero);
		
		return ResponseEntity.ok().body(livros);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Livros obj) {
		
		Livros livros = livrosService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(livros).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Livros obj, @PathVariable Integer id) {
		
		obj.setId(id);
		
		obj = livrosService.update(id, obj);
		
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		
		livrosService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value = "/delisbn/{isbn}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteByIsbn(@PathVariable String isbn) {
		
		livrosService.deleteByIsbn(isbn);
		
		return ResponseEntity.noContent().build();
	}
}
