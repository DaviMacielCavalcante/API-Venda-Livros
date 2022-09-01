package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class ItemPedido {

	private List<Pedidos> pedido = new ArrayList<>();
	private List<Livros> livro = new ArrayList<>();
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {		
	}

	public ItemPedido(Integer quantidade, Double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
	}	
}