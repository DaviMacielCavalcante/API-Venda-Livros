package com.apiVendasLivros.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.Pedidos;
import com.apiVendasLivros.repositories.PedidosRepository;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository repository;
	
	public Pedidos findById(Integer id) {
		Optional<Pedidos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + Pedidos.class.getName()));
	}
	
	public Pedidos insert(Pedidos obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Pedidos update(Integer id, Pedidos obj) {
		Pedidos entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Pedidos entity, Pedidos obj) {
		entity.setId(obj.getId());
		entity.setStatus(obj.getStatus());		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
