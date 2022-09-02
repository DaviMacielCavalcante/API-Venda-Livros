package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "item_pedido")
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_item_pedido")
	private List<Pedidos> pedido = new ArrayList<>();
	
	@OneToOne
	private Livros livro;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {		
	}

	public ItemPedido(Integer quantidade) {
		this.quantidade = quantidade;
		this.preco = livro.getPreco();
	}		

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(Double preco) {
		this.preco = livro.getPreco();
	}
	
	public Double subTotal() {
		return quantidade * preco;
	}
}