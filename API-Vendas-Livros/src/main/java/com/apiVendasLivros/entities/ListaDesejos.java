package com.apiVendasLivros.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ListaDesejos {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Livros item;
	private Integer quantidade;
	private DadosConta conta;
	
	public ListaDesejos() {		
	}

	public ListaDesejos(Integer id, Livros item, Integer quantidade, DadosConta conta) {
		this.id = id;
		this.item = item;
		this.quantidade = quantidade;
		this.conta = conta;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setItem(Livros item) {
		this.item = item;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}