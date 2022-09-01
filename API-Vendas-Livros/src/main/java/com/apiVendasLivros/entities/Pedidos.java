package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apiVendasLivros.enums.StatusPedido;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "pedidos")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedidos {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date momento;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "id_pedidos")
	private DadosConta conta;
	
	@OneToMany(mappedBy = "pedidos")	
	private List<ItemPedido> itemPedido = new ArrayList<>();
	private Double total;
	
	public Pedidos() {		
	}

	public Pedidos(Integer id, Date momento, StatusPedido status, DadosConta conta) {
		this.id = id;
		this.momento = momento;
		this.status = status.getCod();
		this.conta = conta;
		this.total = total(itemPedido);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPedido getStatus() {
		return StatusPedido.toEnum(status);
	}

	public void setStatus(StatusPedido status) {
		this.status = status.getCod();
	}

	public Date getMomento() {
		return momento;
	}

	public DadosConta getConta() {
		return conta;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}	
	
	public Double getTotal() {
		return total;
	}
	
	public Double total(List<ItemPedido> itemPedidos) {
		
		double total = 0;
		
		for (ItemPedido i : itemPedidos) {
			total = total + i.subTotal();
		}
		
		return total;
	}	
}