package com.apiVendasLivros.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiVendasLivros.entities.DadosConta;
import com.apiVendasLivros.services.DadosContaService;

@RestController
@RequestMapping(value = "/conta")
public class DadosContaResource {

	@Autowired
	private DadosContaService dadosService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DadosConta> findById(@PathVariable Integer id){
		
		DadosConta conta = dadosService.findById(id);
		
		return ResponseEntity.ok().body(conta);		
	}
	
	@RequestMapping(value = "/e/{email}", method = RequestMethod.GET)
	public ResponseEntity<DadosConta> findByEmail(@PathVariable String email){
		
		DadosConta conta = dadosService.findByEmail(email);
		
		return ResponseEntity.ok().body(conta);		
	}
	
	@RequestMapping(value = "/c/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<DadosConta> findByCpf(@PathVariable String cpf){
		
		DadosConta conta = dadosService.findByEmail(cpf);
		
		return ResponseEntity.ok().body(conta);		
	}
	
	@RequestMapping(value = "/cel/{telefone}", method = RequestMethod.GET)
	public ResponseEntity<DadosConta> findByTelefone(@PathVariable Integer telefone){
		
		DadosConta conta = dadosService.findByTelefone(telefone);
		
		return ResponseEntity.ok().body(conta);		
	}
	
	@RequestMapping(value = "/contas", method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<DadosConta> contas = dadosService.findAll();
		
		return ResponseEntity.ok().body(contas);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody DadosConta conta){
		
		DadosConta novaConta = dadosService.insert(conta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(novaConta.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody DadosConta conta, @PathVariable Integer id){
		conta.setId(id);
		
		conta = dadosService.update(id, conta);		
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		
		dadosService.deleteById(id);
		
		return ResponseEntity.noContent().build();	
	}
}
