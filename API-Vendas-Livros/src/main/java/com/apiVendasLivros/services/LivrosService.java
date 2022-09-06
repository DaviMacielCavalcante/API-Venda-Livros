package com.apiVendasLivros.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiVendasLivros.entities.Livros;
import com.apiVendasLivros.repositories.LivrosRepository;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository repository;
	
	public Livros findById(Integer id) {
		Optional<Livros> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id, "Tipo: " + Livros.class.getName()));
	}
	
	public Livros findByTitulo(String titulo) {
		Optional<Livros> obj = repository.findByTitulo(titulo);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + titulo, "Tipo: " + Livros.class.getName()));
	}
	
	public Livros findByIsbn(String isbn) {
		Optional<Livros> obj = repository.findByIsbn(isbn);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + isbn, "Tipo: " + Livros.class.getName()));
	}
	
	public List<Livros> findByAutor(String autor) {
		List<Livros> livros = repository.findByAutor(autor);
		return livros;
	}
	
	public List<Livros> findByGenero(String genero){
		List<Livros> livros = repository.findByGenero(genero);
		return livros;
	}
	
	public List<Livros> findAll(){
		List<Livros> livros = repository.findAll();
		return livros;
	}
	
	public Livros insert(Livros obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return repository.save(obj);
	}
	
	public Livros update(Integer id, Livros obj) {
		Livros entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Livros entity, Livros obj) {
		entity.setId(obj.getId());
		entity.setAcabamento(obj.getAcabamento());
		entity.setAutor(obj.getAutor());
		entity.setEdicao(obj.getEdicao());
		entity.setEditora(obj.getEditora());
		entity.setEncomenda(obj.getEncomenda());
		entity.setForaDeLinha(obj.getForaDeLinha());
		entity.setFormatoDigital(obj.getFormatoDigital());
		entity.setGenero(obj.getGenero());
		entity.setIdioma(obj.getIdioma());
		entity.setIsbn(obj.getIsbn());
		entity.setNumeroEdicao(obj.getNumeroEdicao());
		entity.setNumeroPaginas(obj.getNumeroPaginas());
		entity.setPaisDeOrigem(obj.getPaisDeOrigem());
		entity.setPreco(obj.getPreco());
		entity.setProdutoDigital(obj.getProdutoDigital());
		entity.setTitulo(obj.getTitulo());
		entity.setTradutor(obj.getTradutor());
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void deleteByIsbn(Integer isbn) {
		repository.deleteByIsbn(isbn);
	}
}
