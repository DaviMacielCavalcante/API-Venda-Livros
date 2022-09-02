package com.apiVendasLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.Enderecos;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Integer> {
}
