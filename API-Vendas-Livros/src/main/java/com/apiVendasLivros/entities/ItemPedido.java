package com.apiVendasLivros.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "item_pedido")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "pedidos_item_pedido", 
	joinColumns = @JoinColumn(name = "id_pedidos", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "id_item_pedido", referencedColumnName = "id"))
	private List<Pedidos> pedido = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_livros")
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
	
	public Double getSubTotal() {
		return quantidade * preco;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getLivro().getTitulo());
		builder.append(", Qte: ");
		builder.append(getQuantidade());
		builder.append(", Preço Unitário: ");
		builder.append(nf.format(getPreco()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}
}