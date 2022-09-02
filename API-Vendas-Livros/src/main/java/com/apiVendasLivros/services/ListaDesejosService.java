package com.apiVendasLivros.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.ListaDesejos;
import com.apiVendasLivros.repositories.ListaDesejosRepository;

@Service
public class ListaDesejosService {

	@Autowired
	private ListaDesejosRepository repository;
	
	public ListaDesejos findById(Integer id) {
		Optional<ListaDesejos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + ListaDesejos.class.getName()));
	}
	
	public ListaDesejos insert(ListaDesejos obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}	
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
