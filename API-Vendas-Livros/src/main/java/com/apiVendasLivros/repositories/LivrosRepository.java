package com.apiVendasLivros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiVendasLivros.entities.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {

	Optional<Livros> findByTitulo(String titulo);
		
	Optional<Livros> findByIsbn(String isbn);
	
	List<Livros> findByAutor(String autor);
	
	List<Livros> findByGenero(String genero);
	
	void deleteByIsbn(Integer isbn);
	
}
