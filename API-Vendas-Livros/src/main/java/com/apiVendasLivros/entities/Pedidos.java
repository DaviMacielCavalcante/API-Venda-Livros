package com.apiVendasLivros.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.apiVendasLivros.enums.StatusPedido;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedidos {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date momento;
	private Integer status;
	private DadosConta conta;
	private List<ItemPedido> itemPedido = new ArrayList<>();
	
	public Pedidos() {		
	}

	public Pedidos(Integer id, Date momento, StatusPedido status, DadosConta conta) {
		this.id = id;
		this.momento = momento;
		this.status = status.getCod();
		this.conta = conta;
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
}