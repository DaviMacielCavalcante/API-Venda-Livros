package com.apiVendasLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.DadosConta;

@Repository
public interface DadosContaRepository extends JpaRepository<DadosConta, Integer> {
}
