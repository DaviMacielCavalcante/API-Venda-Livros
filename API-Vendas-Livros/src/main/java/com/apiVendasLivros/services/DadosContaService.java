package com.apiVendasLivros.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.DadosConta;
import com.apiVendasLivros.repositories.DadosContaRepository;

@Service
public class DadosContaService {

	@Autowired
	private DadosContaRepository repository;
	
	public DadosConta findById(Integer id) {
		Optional<DadosConta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + DadosConta.class.getName()));
	}
	
	public DadosConta insert(DadosConta obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public DadosConta update(Integer id, DadosConta obj) {
		DadosConta entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(DadosConta entity, DadosConta obj) {
		entity.setId(obj.getId());
		entity.setCpf(obj.getCpf());
		entity.setDataNasc(obj.getDataNasc());
		entity.setEmail(obj.getEmail());
		entity.setNome(obj.getNome());
		entity.setSobreNome(obj.getSobreNome());
		entity.setTelefone(obj.getTelefone());		
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
