package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "lista_desejos")
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ListaDesejos {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	private List<Livros> item = new ArrayList<>();	
	
	@ManyToOne
	@JoinColumn(name = "id_lista_desejos")
	private DadosConta conta;
	
	private Double total;

	public ListaDesejos() {
	}

	public ListaDesejos(Integer id, DadosConta conta) {
		this.id = id;		
		this.conta = conta;
		this.total = Total();
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public Double Total() {
		for (Livros i : item) {
			total = total + i.getPreco();
		}

		return total;
	}

}