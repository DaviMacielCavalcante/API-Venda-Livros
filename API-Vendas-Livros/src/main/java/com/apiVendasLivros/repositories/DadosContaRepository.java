package com.apiVendasLivros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.DadosConta;

@Repository
public interface DadosContaRepository extends JpaRepository<DadosConta, Integer> {
	
	Optional<DadosConta> findByEmail(String email);
	
	Optional<DadosConta> findByCpf(String cpf);
	
	Optional<DadosConta> findByTelefone(Integer telefone);
}
