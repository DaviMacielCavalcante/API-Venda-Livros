package com.apiVendasLivros.services;

import java.util.List;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, 
				"Tipo: " + DadosConta.class.getName()));
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

	public DadosConta findByEmail(String email) {
		Optional<DadosConta> obj = repository.findByEmail(email);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não existe conta com o seguinte email: " + email,
				"Tipo: " + DadosConta.class.getName()));	
	}
	
	public DadosConta findByCpf(String cpf) {
		Optional<DadosConta> obj = repository.findByCpf(cpf);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não existe conta com o seguinte cpf: " + cpf,
				"Tipo: " + DadosConta.class.getName()));	
	}
	
	public DadosConta findByTelefone(Integer telefone) {
		Optional<DadosConta> obj = repository.findByTelefone(telefone);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não existe conta com o seguinte email: " + telefone,
				"Tipo: " + DadosConta.class.getName()));	
	}
	
	public List<DadosConta> findAll() {
		List<DadosConta> contas = repository.findAll();
		return contas;
	}
}
