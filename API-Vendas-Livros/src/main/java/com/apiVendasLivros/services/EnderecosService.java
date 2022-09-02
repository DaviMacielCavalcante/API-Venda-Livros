package com.apiVendasLivros.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.Enderecos;
import com.apiVendasLivros.repositories.EnderecosRepository;

@Service
public class EnderecosService {

	@Autowired
	private EnderecosRepository repository;
	
	public Enderecos findById(Integer id) {
		Optional<Enderecos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + Enderecos.class.getName()));
	}
	
	public Enderecos insert(Enderecos obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Enderecos update(Integer id, Enderecos obj) {
		Enderecos entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Enderecos entity, Enderecos obj) {
		entity.setId(obj.getId());
		entity.setBairro(obj.getBairro());
		entity.setCep(obj.getCep());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setNumero(obj.getNumero());
		entity.setPaisdeOrigem(obj.getPaisdeOrigem());
		entity.setRua(obj.getRua());
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
