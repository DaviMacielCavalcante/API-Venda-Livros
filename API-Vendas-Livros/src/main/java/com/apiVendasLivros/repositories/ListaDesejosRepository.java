package com.apiVendasLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.ListaDesejos;

@Repository
public interface ListaDesejosRepository extends JpaRepository<ListaDesejos, Integer> {
}
