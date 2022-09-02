package com.apiVendasLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {
}
