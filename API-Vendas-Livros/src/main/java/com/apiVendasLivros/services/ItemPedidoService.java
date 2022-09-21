package com.apiVendasLivros.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.ItemPedido;
import com.apiVendasLivros.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;
	
	public ItemPedido findById(Integer id) {
		Optional<ItemPedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + ItemPedido.class.getName()));
	}
	
	public ItemPedido insert(ItemPedido obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public ItemPedido update(Integer id, ItemPedido obj) {
		ItemPedido entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ItemPedido entity, ItemPedido obj) {
		entity.setId(obj.getId());
		entity.setLivro(obj.getLivro());
		entity.setQuantidade(obj.getQuantidade());		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
